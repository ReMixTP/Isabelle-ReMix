all: docker

docker: target/universal/isabelle-remix-0.1.0.zip Dockerfile
	docker build -t "remix/isabelle" .

target/universal/isabelle-remix-0.1.0.zip: source $(shell find project -type f) build.sbt
	sbt dist

source: src/IsabelleReMix.scala-nw
	notangle -RMakefile src/IsabelleReMix.scala-nw | unexpand --first-only > src/Makefile
	cd src && $(MAKE) source

run:
	docker run -p 5001:9000 -it --rm remix/isabelle

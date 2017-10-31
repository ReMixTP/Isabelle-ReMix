all: docker

docker: target/universal/isabelle-remix-0.1.0.zip Dockerfile
	docker build -t "remix/isabelle" .

target/universal/isabelle-remix-0.1.0.zip: $(shell find src -type f) $(shell find project -type f) build.sbt
	sbt dist

run:
	docker run -p 5001:9000 -it --rm remix/isabelle isabelle-remix

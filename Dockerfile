FROM makarius/isabelle:Isabelle2017
USER root
WORKDIR /
RUN apt-get -y update && apt-get install -y openjdk-8-jre
COPY isabelleRunner.sh /isabelleRunner.sh
RUN chmod +x /isabelleRunner.sh
COPY target/universal/isabelle-remix-0.1.0.zip /
RUN unzip /isabelle-remix-0.1.0.zip
RUN echo play.http.secret.key=$(head /dev/urandom | tr -dc A-Za-z0-9 | head -c50) >> /isabelle-remix-0.1.0/conf/application.conf
EXPOSE 9000
RUN chown isabelle /isabelle-remix-0.1.0
USER isabelle
WORKDIR /home/isabelle
ENTRYPOINT ["/isabelle-remix-0.1.0/bin/isabelle-remix"]
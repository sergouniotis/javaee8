FROM openjdk:8-jdk-alpine

MAINTAINER Thanassis Sergouniotis "t.sergouniotis@inopus.de"

#remove cache in order to minimize size
RUN rm -rf /var/cache/apk/* \
		&& wget http://download.jboss.org/wildfly/12.0.0.Final/wildfly-12.0.0.Final.tar.gz \
		&& cp wildfly-12.0.0.Final.tar.gz /usr/local \
		&& cd /usr/local && tar xvfz wildfly-12.0.0.Final.tar.gz 

ENV JBOSS_HOME /usr/local/wildfly-12.0.0.Final
ENV LAUNCH_JBOSS_IN_BACKGROUND false

ADD target/libs/postgresql.jar /opt/postgresql.jar
ADD target/webapp.war /opt/webapp.war

ADD docker/run.sh /run.sh
ADD docker/conf.cli /conf.cli

EXPOSE 8080
EXPOSE 8787
EXPOSE 9000
EXPOSE 9999
EXPOSE 9990

ENTRYPOINT ["/bin/sh", "run.sh" ]

CMD tail -f /dev/null

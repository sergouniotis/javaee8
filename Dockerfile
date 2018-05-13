FROM java:8

MAINTAINER Thanassis Sergouniotis "tsergouniotis@ekmechanes.com"

##-qq suppress output that we dont need in dockerfile
RUN apt-get -qq update

RUN apt-get -qq -y install vim apt-utils

RUN apt-get -qq -y install supervisor

RUN wget http://download.jboss.org/wildfly/12.0.0.Final/wildfly-12.0.0.Final.tar.gz
RUN cp wildfly-12.0.0.Final.tar.gz /usr/local

ADD target/libs/postgresql.jar /opt

#RUN wget https://jdbc.postgresql.org/download/postgresql-42.0.0.jar
#RUN cp postgresql-42.0.0.jar /opt

#COPY servers/wildfly-12.0.0.Final.tar.gz /usr/local

RUN cd /usr/local\
	&& tar xvfz wildfly-12.0.0.Final.tar.gz 

ENV JBOSS_HOME /usr/local/wildfly-12.0.0.Final
ENV LAUNCH_JBOSS_IN_BACKGROUND false

RUN mkdir /var/log/supervisord
RUN mkdir /var/log/alm

ADD target/webapp.war /opt/webapp.war


ADD docker/run.sh /run.sh
ADD docker/conf.cli /conf.cli
ADD docker/supervisord.conf /etc/supervisor/conf.d/supervisord.conf
ADD docker/processlistener.py /processlistener.py

EXPOSE 8080
EXPOSE 8787
EXPOSE 9000
EXPOSE 9999
EXPOSE 9990

ENTRYPOINT ["/bin/bash", "run.sh" ]
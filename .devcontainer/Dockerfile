## **********************************************************************************
## Se genera la estructura del contenedor así como la integración de las herramientas
## a utilizar como parte del ambiente de desarrollo.
## **********************************************************************************
FROM openjdk:8-jdk

## **********************************************************************************
## Se generan variables locales
## **********************************************************************************
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID

## **********************************************************************************
## Se deshabilita el modo interactivo al realizar las tareas de instalación
## **********************************************************************************
ENV DEBIAN_FRONTEND=noninteractive

## **********************************************************************************
## Se instalan las herramientas deseadas así como también se genera el usuario a 
## utilizar dentro del contenedor.
## **********************************************************************************
RUN apt-get update \
    && apt-get -y install --no-install-recommends apt-utils dialog 2>&1 \
    && groupadd --gid $USER_GID $USERNAME \
    && useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && apt-get install -y sudo \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME\
    && chmod 0440 /etc/sudoers.d/$USERNAME \
    && apt-get -y install git iproute2 procps curl lsb-release

## **********************************************************************************
## Se realiza la instalación manual de Maven en el contenedor.
## **********************************************************************************
ARG MAVEN_VERSION=3.6.3
ARG MAVEN_SHA=c35a1803a6e70a126e80b2b3ae33eed961f83ed74d18fcd16909b2d44d7dada3203f1ffe726c17ef8dcca2dcaa9fca676987befeadc9b9f759967a8cb77181c0
ENV MAVEN_HOME=/usr/share/maven
RUN mkdir -p ${MAVEN_HOME} ${MAVEN_HOME}/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${MAVEN_SHA} /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C ${MAVEN_HOME} --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn
COPY maven-settings.xml ${MAVEN_HOME}/ref/
ENV MAVEN_CONFIG /root/.m2

## **********************************************************************************
## Se ejecutan comandos para limpiar y liberar espacio posterior a la instalación de 
## las herramientas.
## **********************************************************************************
RUN apt-get autoremove -y \
    && apt-get clean -y \
    && rm -rf /var/lib/apt/lists/*

## **********************************************************************************
## Se habilita el modo interactivo para su uso posterior en el contenedor
## **********************************************************************************
ENV DEBIAN_FRONTEND=dialog

## **********************************************************************************
## Se habilita la variable de ambiente JAVA_HOME con el directorio asignado por la 
## imagen a la instalación de Java.
## **********************************************************************************
RUN if [ ! -d "/docker-java-home" ]; then ln -s "${JAVA_HOME}" /docker-java-home; fi

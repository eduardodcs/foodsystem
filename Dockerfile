FROM openjdk:17-alpine

	ENV APP_NAME foodsystem

	COPY ./target/${APP_NAME}.jar  /app/${APP_NAME}.jar

	RUN wget https://bin.equinox.io/c/bNyj1mQVY4c/ngrok-v3-stable-linux-amd64.tgz
    RUN tar xvzf ngrok-v3-stable-linux-amd64.tgz -C /usr/local/bin
    RUN /bin/sh -c "apk add --no-cache bash"

	WORKDIR /app

	COPY ./entrypoint.sh .
	RUN chmod +x *.sh

    ENTRYPOINT sh entrypoint.sh
	#CMD java -jar ${APP_NAME}.jar

	EXPOSE 8080
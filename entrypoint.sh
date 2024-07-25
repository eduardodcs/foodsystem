#!bin/bash

exec ngrok config add-authtoken 2jWf5lJ8Kc0tXyBoOkA53D2mctY_6TFj6XHxQ4rydyK1yeQuE &
exec ngrok http --domain=distinct-monitor-topical.ngrok-free.app 8080 &
exec java -jar foodsystem.jar
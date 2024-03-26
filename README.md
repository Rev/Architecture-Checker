# Architecture Checker

This just checks what architecture an installed application is using to load its libraries!

## About

Recently, I've seen that many people have been creating their own injectors on Android. The issue is, most are injecting a library chosen based on the devices architecture, rather than the installed applications library architecture.

Lets say that a game you installed had armv7a libraries, whilst your device had an armv8a CPU. If you solely inject a library based on the architecture of your device, rather than the architecture your application is using, then you're going to have issues. In this case, you would be injecting an armv8a library into an armv7a game.

This is a big problem, but, it is very easy to fix. This can be easily implemented with your current code. 

https://user-images.githubusercontent.com/64957743/196193864-a7305c23-218e-4900-9086-05b0b5d83698.mp4

![image](https://user-images.githubusercontent.com/64957743/196131471-246967dd-cda3-46b7-89c8-efedc6527135.png)

# Architecture Checker

This just checks what architecture an application is using for its libraries.

## About

Recently, I've seen that many people have been creating their own injectors on Android. The issue is, most are injecting a library chosen based on the devices architecture, rather than the installed applications library architecture.

Lets say that a game you installed had armv7a libraries, whilst your device had an armv8a CPU. If you solely check the architecture of your device, rather than the architecture your application is using, then you're going to have issues. In this case, you would be injecting an armv8a library into an armv7a game.

This is a big problem, but, it is very easy to fix. This can be easily implemented with your current code. 

https://user-images.githubusercontent.com/64957743/196193864-a7305c23-218e-4900-9086-05b0b5d83698.mp4

## Details

- Bitcoin: bc1qcepeyjfhepzn6hgplwmeyd6e5nr7kzzthupw97
- Ethereum: 0x2cE97b99abe0C46f6436aAc08B06B1483820D805
- Polkadot: 16BDfmSGBw7ih258iD8Hkhw8Ko6bHBvAdcLe69ZBweWX2q6F
- Solana: AYc9Ai2KtoVH4okkzXbEaYK6r7tnNJYmATzaE8FUpbLa
- Ripple: rDe9hxTBVxMBGdPdj4zeBQhUN9TrPkQ5mu
- Litecoin: ltc1qlcsgf9mvd68tf0s5250sw0slexf7xktku3cpdc

![image](https://user-images.githubusercontent.com/64957743/196131471-246967dd-cda3-46b7-89c8-efedc6527135.png)
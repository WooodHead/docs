# Mobile Framework Overview

## Webview & basic JS bridge(& hybrid)

### [Aoache Cordova](https://en.wikipedia.org/wiki/Apache_Cordova)

### [Sencha]

### [reapp]

### [ionic]

### [trigger]

## Compile to Native binary

### [FireMonkey]

### [Xamarin]

## Native

### [Swift]

### [ObjectC]

## Native components via JS bridge

### [React Native]

  React Native runs in JavaScript core in a separate thread on iOS the main thread that runs the irregulare iOS code rightand then you have a separate thread with JavaScript core where all of your JavaScript app logic execute

- Free, open source tooling with liberal license
- Live-reload: instant feedback

  You can get instant feedback so it's like what you would see in a browser when you turn on live reload you change the file you see it automatically update in the window the axact same thing you get that here and i want ot emphasize again that it's not like reloading a webview inside of it is actually these are native components that are being manipulated

- Functional UI: a better abstractioin

- Apple sanctioned OTA updates

  OTAs like over-the-air updates so you don't have to go through the Apple submission processs so long as you don't change the main funcationality of the app. you open the app for the first thime it would download the javascript from wherever you're storing it and then at some interval or over websockets it could just check is there an update if there is download the new one store that use that as your as the code base
  
  OTA updates
  An Application may not download or install executable code. Interpreted code may only be used in an Application if all scripts. code and interpreters are packaged in the Application and not download. The only exception to the foregoing is scripts and code downloaded and run by Apple's builtin Webkit framework or JavascriptCore, provided that such scripts and code do not change the primary purpose of the Applicaton by providing features or funcationality that are inconsistent with the intended and advertised purpose of the Application as submitted to the App Store.

- Intuitive Flexbox layout, CSS styles

  flexbox yet it solves so many problems that you have with layout. I personally like I don't want to make websites with our flex anymore although I have to but I don't want to

- Same skill-set, similar APIs on each platform: React

  Android verison of react native hasn't been released yet they are using it internally at Facebook and building it and building apps in it but they don't release code that they're not using a production and they haven't actually shipped an Android app with react native whereas they shipped serveral iOS Android apps.
  platform-specific api's because certain idioms related to the user interface don't exist in iOS or don't exist in Android like you get that little button in the corner for Android that I don't know what that's action button or something that you see with material design that just doesn't exist in iOS so there would be an API difference for that

- Share common code via JavaScript

- Native UI components

  Native UI components it's a big one and what I think is really nice is the powerfully plug-in API so it's so easy to make your javascirpt interact with any of the native side like wrapping different components that aren't builtin or accessing some functionality like for example the Facebook login

- Simple and powerful Native plugin API

### [Tutanium]

## Reference

- [Introducton to React Native](http://brentvatne.ca/react-native-intro-talk/)

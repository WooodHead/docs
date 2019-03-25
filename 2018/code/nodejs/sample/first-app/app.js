// access log function defined in the logger module 
// const will be used for not allowing to assign new value
const logger = require('./logger');

function sayHello(name) {
    global.console.log('Hello ' + name);
    console.log('Hello '+ name + '!');
    logger.log('your name : '+ name + ' will be loggered');
}

sayHello ('zhuqiang');
// console.log(window);
// node app.js
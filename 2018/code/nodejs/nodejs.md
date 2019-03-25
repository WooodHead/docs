# nodejs overview

  An runtime environment for executing JavaScropt code outside of a browser. We often use Node to build back-end services.

- Great for prototyping and agile development
- Superfast and highly scalable services such as PayPal, Uber, Netflix, Walmart
- JavaScript everywhere
- Clearner and more consistent codebase
- Large ecosystem of open-source libs

## Node Architecture

### JavaScript Engine

- IExplore Browser - Chakra
- Firefox Browser- SpiderMonkey
- Chrome Browser - V8
- Before 2009, JavaScript can run Browser only
- Ryan Dahl
- Node Engine includes the V8 JavaScript engine plus some addtional modules that give us capabilities not vailable inside browsers that we can work with the file system or the network and so on
- Node is not programming language

### How node works?

- non-blocking or asynchronous.
- Node is ideal for I/O-intensive apps that include a lot of disk or network access that we can serve more clients without the need to throw in more hardware
- node should not be used for CPU-intensive applications like a video coding or an image manipulation service in this kind of applications we have a lot of calculations that should be done by CPU and few operaton that touch the file system or the network no the application are single threaded when performing the caculations to servce one client other clients have have to wait and that's why node should not be used for CPU-intensive applications
- it should only be used for building data-intensive and real-time application
- node is written by C++, node passes js to v8 for execution

### development experience

- Node Package Manager(NPM)
- Asynchronous JavaScript
- CRUD Operations
- Data Validation
- Authentication and Authorization
- Handling and logging Errors
- Unit and Integration Testing
- Test-driven Development
- Development in the Cloud
- Clean Coding and Refactoring
- Security Best Practices
- Useful Libraries
- backtick ` ` which means template string in es6 ir ES 2015 that is short for ECMAScript 6 or 2015

  ```node
  const os = require('os');
  var totalMemory = os.totalmem();
  console.log('Total Memory:' + totalMemory());
  console.log(`Total Memory : ${totalMemory}`);
  ```

- Node have function and Class

  ```node Class
  const EventEmitter = require('events');
  const emitter = new EventEmitter();
  //Register a listener
  emitter.on('messageLogged',function(arg){
      console.log('listener called',arg);
  })
  //Raise an event
  emitter.emit('messageLogged',{id:1,url:'http://'});
  ```

- Arrow Funciton

 ```node
 const EventEmitter = require('events');
  const emitter = new EventEmitter();
  //Register a listener
  emitter.on('messageLogged',(arg) => { // arrow function
      console.log('listener called',arg);
  })
  //Raise an event
  emitter.emit('messageLogged',{id:1,url:'http://'});
 ```

## Reference

- [Node.js Tutorial for Beginners](https://www.youtube.com/watch?v=TlB_eWDSMt4)

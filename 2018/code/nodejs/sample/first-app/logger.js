
var url = "http://mylogger.io/log";

function log(message){
    // Send an HTTP request
    console.log(message);
}

// to access log function in the other module outside 
module.exports.log = log;
//module.exports.endPoint = url;
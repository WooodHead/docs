const fs = require('fs');
fs.readFile('../nodejs.md',(err,data) =>{
  if (err) throw err;
  console.log(data);
});

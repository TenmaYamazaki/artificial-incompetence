/**
 * 
 */
function res() {
  const reszone = document.getElementById('reszone');
  const adjective = document.getElementById('adjective').value;
  const noun = document.getElementById('noun').value;
  
  var url;
  
  if(adjective == 0 || noun == 0) {
    url = "/question/" + adjective + "/" + noun;
    send();
  } else if(adjective == 1 || noun == 1) {
    reszone.innerHTML = "何か質問してね";
  } else {
    url = "/question/" + adjective + "/" + noun;
    send();
  }
    
    function send(){
        
      const xhr = new XMLHttpRequest();
      
      xhr.open('GET', url, true);
      
      xhr.addEventListener('load', function(){
        const response = JSON.parse(xhr.responseText);
          
        reszone.innerHTML = "ぱぐ「" + response.word + "」";
          
      });
      xhr.send();
    }
  }

window.onload = addNode;

function addNode()
{
document.getElementsByTagName("form")[0].onsubmit = make;
}

function make()
{
//alert("hello");
var inText = document.getElementById("textArea").value;
var newText = document.createTextNode(inText);

var comment = document.createElement("p");
comment.appendChild(newText);

var getbody = document.getElementsByTagName("body")[0];
getbody.appendChild(comment);

return false;

}
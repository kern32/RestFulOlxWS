/**
 * Created by kernel32 on 31.03.2018.
 */
function deleteKeyValue(){
    var action_src = "./rest/key/delete/" + document.getElementsByName("keyValue")[0].value;
    var your_form = document.getElementById('deleteKeyForm');
    your_form.action = action_src ;
}
function getKeyValue(){
    var action_src = "./rest/key/get/" + document.getElementsByName("keyValue")[0].value;
    var your_form = document.getElementById('getKeyForm');
    your_form.action = action_src ;
}
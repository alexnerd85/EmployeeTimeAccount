function populateEmployeeForm(form, data){
    resetForm(form);
    $.each(data, function(key, value){
        $('[name='+key+']', form).val(value);
    });
    
    /*
    $.each(data, function(key, value) {  
        var ctrl = $('[name='+key+']', frm);  
        switch(ctrl.prop("type")) { 
            case "radio": case "checkbox":   
                ctrl.each(function() {
                    if($(this).attr('value') == value) $(this).attr("checked",value);
                });   
                break;  
            default:
                ctrl.val(value); 
        }  
    });
    */
};

function resetForm(form){
    $(':input', form).each( function() {
        if(this.type=='text'){
             this.value = '';
        }
    });
    
    /*
    $(':input', form).not('#accountType').each( function() {
    if(this.type=='text' || this.type=='textarea'){
             this.value = '';
       }
    else if(this.type=='radio' || this.type=='checkbox'){
         this.checked=false;
      }
         else if(this.type=='select-one' || this.type=='select-multiple'){
              this.value ='All';
     }
 });
 */
}

var fechaDeHoy = new Date();

//validar que los campos tengan datos
$('#sugerencia-btn').click(function (e) {
    var valido = true;
    limpiarErrores() 
    let inputs = document.querySelectorAll('.form-group');
    $(inputs).each(function (index, element) {
        // element == this
        let input = $(element).find('.form-control');
        if(input.val() == ""){
            //accedo al elemento padre para poner el mensaje de error como otro hijo
            $(element).append('<span class="font-italic alert-danger" id="leyendaError"> El campo no debe estar vacío </span>');
            valido=false;
        }        
    }); 


    if(valido == false)
        e.preventDefault();
});

//limpia los errores de los inputs para que cuando completen los campos correctamente no aparezca el error
function limpiarErrores(){
    let camposConErrores =  document.querySelectorAll('#leyendaError');
    if(camposConErrores.length != 0){
        $(camposConErrores).each( function (index, element){
            $(element).remove();
        });
    }
}

$("#mail").change(function(){

    let regexMail = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/

    if(!regexMail.test(this.value) || this.value == "")
        this.setCustomValidity("La dirección de correo electrónica es inválida")
    else
        this.setCustomValidity("")
});

$("#telefono").change(function(){

    let regextel = /^\d{8,15}$/

    if(!regextel.test(this.value) || this.value == "")
        this.setCustomValidity("el teléfono es inválido")
    else
        this.setCustomValidity("")
});


$("#fecha-desaparicion").change(function (){

    if(Date.parse(this.value) > Date.parse(fechaDeHoy))
        this.setCustomValidity("La fecha es mayor a la fecha actual ");
    else
        this.setCustomValidity("")

})


/****************************************INDEX**************************/
function filtrarSubItem(listaDeSubItem, idItem, idSubitem, idItemAsociado ){
    
    //limpia localidades de partido anterior
    let listaOptionAEliminar = $(idSubitem).find('option')
    $(listaOptionAEliminar).each(function (index, element){

        //Para no borrar el primer option
        if(index > 0)
            $(element).remove()
    });

    //Agrega localidades para ese partido
    $(listaDeSubItem).each(function (index, element){
        if($(idItem).val() == element[idItemAsociado]){
            let content = '<option value=' + element.id + '>' + element.nombre +'</option>'
            $(idSubitem).append(content);
        }
    });
    
    $(idSubitem).prop('disabled', false);
}


/*$('#buscar').click(function (e) {
    e.preventDefault();
    var filtro = {};
    //filtro.partido = $('#partido').val();
    filtro.localidad = $('#localidad').val();
    filtro.color1 = $('#color1').val();
    filtro.color2 = $('#color2').val();
    filtro.tipoMascota = $('#mascota').val();
    filtro.raza = $('#raza').val();
    console.log(filtro)

    $.ajax({
        type: "post",
        contentType: "application/json",
        url: window.location.href + "/ver-mascotas",
        data: JSON.stringify(filtro),
        dataType: "json",
        success: function (response) {
            alert('assssssssssssssssss');
            console.log(response);
//            window.location.replace(response)
        }
        //async: false
    });
    
});*/
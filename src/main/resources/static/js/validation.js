var fechaDeHoy=new Date;function limpiarErrores(){let e=document.querySelectorAll("#leyendaError");0!=e.length&&$(e).each(function(e,a){$(a).remove()})}function filtrarSubItem(e,a,t,i){let o=$(t).find("option");$(o).each(function(e,a){e>0&&$(a).remove()}),$(e).each(function(e,o){if($(a).val()==o[i]){let e="<option value="+o.id+">"+o.nombre+"</option>";$(t).append(e)}}),$(t).prop("disabled",!1)}$("#sugerencia-btn").click(function(e){var a=!0;limpiarErrores();let t=document.querySelectorAll(".form-group");$(t).each(function(e,t){""==$(t).find(".form-control").val()&&($(t).append('<span class="font-italic alert-danger" id="leyendaError"> El campo no debe estar vacío </span>'),a=!1)}),0==a&&e.preventDefault()}),$("#mail").change(function(){/^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/.test(this.value)&&""!=this.value?this.setCustomValidity(""):this.setCustomValidity("La dirección de correo electrónica es inválida")}),$("#telefono").change(function(){/^\d{8,15}$/.test(this.value)&&""!=this.value?this.setCustomValidity(""):this.setCustomValidity("el teléfono es inválido")}),$("#fecha-desaparicion").change(function(){Date.parse(this.value)>Date.parse(fechaDeHoy)?this.setCustomValidity("La fecha es mayor a la fecha actual "):this.setCustomValidity("")});
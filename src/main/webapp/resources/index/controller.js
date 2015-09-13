var controller = {

	user : undefined,

	userAndMail : function() {
		this.user = {
			name : $('#name').val(),
			email : $('#email').val()
		}
		if(this.validateFields()){
			this.loadLevels()
			$('#user').hide()
		}else{
			$('#user').prepend($(".alert-required").html())
		}
	},
	
	validateFields: function(){
		return (this.user.name != "") && (this.user.email != "")
	},

	loadLevels : function() {
		that = this;
		$.getJSON("/avaliacao/rest/service/getLevels", function(data) {
			controller.user.abilites = data
		}).done(function() {
			controller.loadLevelForm()
		})
	},

	loadLevelForm : function() {
		var html = Mustache.render($(".level-template").html(), this.user)
		$('#level-form').append(html)
		this.startsProperties()
	},
	
	startsProperties: function(){
		$('input[type="number"]').rating({
			clearCaption: 'Nota 0',
			clearCaptionClass: 'label label-warning',
			starCaptions: {
			    0: 'Nota 0',
			    1: 'Nota 1',
			    2: 'Nota 2',
			    3: 'Nota 3',
			    4: 'Nota 4',
			    5: 'Nota 5',
			    6: 'Nota 6',
			    7: 'Nota 7',
			    8: 'Nota 8',
			    9: 'Nota 9',
			    10: 'Nota 10'
			},
			starCaptionClasses: {
			    0: 'label label-warning',
			    1: 'label label-warning',
			    2: 'label label-warning',
			    3: 'label label-warning',
			    4: 'label label-warning',
			    5: 'label label-warning',
			    6: 'label label-warning',
			    7: 'label label-success',
			    8: 'label label-success',
			    9: 'label label-success',
			    10: 'label label-success'
			}
			})
	},

	finish : function() {
		for ( var n in this.user.abilites) {
			this.user.abilites[n].value = $('#level_'+this.user.abilites[n].skill.id).val()
		}
		this.sendInformation()
		$('#level-form').hide()
		$('#finish').append($(".finish").html())
	},

	sendInformation : function() {
		$.ajax({
			type : "POST",
			url : "/avaliacao/rest/service/finish",
			data : JSON.stringify(controller.user),
			contentType : "application/json;",
			dataType : "json",
			success : function(data) {
				console.log(JSON.stringify(data))
			}
		})
	}
}
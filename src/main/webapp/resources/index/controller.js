var controller = {

	user : undefined,

	userAndMail : function() {
		this.user = {
			name : $('#name').val(),
			email : $('#email').val()
		}
		this.loadLevels()
		$('#user').hide()
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
	},

	finish : function() {
		for ( var n in this.user.abilites) {
			console.log(n)
			this.user.abilites[n].value = $('#level_'+this.user.abilites[n].skill.id).find('input:checked').val()
		}
		this.sendInformation()
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
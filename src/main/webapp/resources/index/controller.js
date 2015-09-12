var controller = {
		
	user: undefined,
	
	userAndMail: function(){
		this.user = {
			name: $('#name').val(),
			email: $('#email').val()
		}
		this.loadLevels()
	},

	loadLevels: function(){
		that = this;
		$.getJSON("/avaliacao/rest/service/getLevels", 
			function( data ){
				that.user.abilites = data
			}
		)
	}
}
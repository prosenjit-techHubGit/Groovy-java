package com.example.demo

import io.groovy.script.SendEmail;

class EmailScript {

	def doEmail() {
		SendEmail sendEmail = new SendEmail();
		sendEmail.email {
			from ('prosenjit')
			to ('Nazeef')
			subject('Happy Diwali')
		};
	}
}


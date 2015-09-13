package avaliacao.sample.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MailParams {

	private String From = "no-reply@avaliacao.com";
	private final String To;
	private String Subject = "Resultado Auto Avaliação";
	private String Tag = "Invitation";
	private final String HtmlBody;
	private final String TextBody;
	private String ReplyTo = "no-reply@avaliacao.com";
	private boolean TrackOpens = true;
}

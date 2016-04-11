
package br.com.tiago.utilitarios;

import br.com.tiago.model.Model;
import br.com.tiago.model.ModelContador;
import br.com.tiago.model.ModelUsuario;
import java.io.File;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class AvisoEmail {
    public boolean enviaAlerta(Model model, ModelUsuario user, String grafico, String mensagem, String arquivo, ModelContador contador, String margem){
    
    HtmlEmail email = new HtmlEmail();
    email.setHostName( "smtp.prolinkcontabil.com.br" );
    email.setSmtpPort(587);

    email.setAuthenticator( new DefaultAuthenticator( "documentos@grupoprolink.com.br" ,  "l!nk2016Cont" ) );
    
    try {
        email.setFrom( "documentos@grupoprolink.com.br" , "Documentos");
        email.setDebug(true); 
        email.setSubject( "Prolink: Oi "+user.getNome()+", tenho um aviso importante para você" );

        String idArquivo = email.embed(new File("imagens/robot.png"));
        
        String idGrafico = email.embed(new File(grafico));
        StringBuilder builder = new StringBuilder();
//+"<span style=\"color:#000000;\"><img alt=\"\" height=\"210\" src=\"http://img.actualidadgadget.com/wp-content/uploads/2015/04/robot-question-300x300.jpg\" style=\"float: right;\" width=\"210\" /></span><br />"
        
        builder.append(
                  "<p style=\"color: blue;\">"
                  +"<span style=\"font-size:20px;\"><strong>Ol&aacute; ").append(user.getNome()).append(";</strong></span><br />"
                  + "<br />"
                  +"<span style=\"color:#000000;\"><em><strong></strong></em>, </span></p>"
                  +"Percebi que existem documentos destinados para voc&ecirc; aguardando sua intera&ccedil;&atilde;o."
                  +"Talvez ainda n&atilde;o tenha visto!</span></p>"
         +"<p>"
                  +"<span style=\"color:#000000;\"><img alt=\"\" height=\"210\" src=\"cid:").append(idArquivo).append("\" style=\"float: right;\" width=\"210\" /></span><br />"

                  +"Tamb&eacute;m notei que voc&ecirc; tem uma margem de fechamento de <span style=\"background-color:#ffff00;\">").append(contador.getMedia()).append("%</span>.&quot;").append(margem).append("</p>"
         +"<p>"
                  +"<em>Voc&ecirc; tem um gr&aacute;fico, aqui...</em></p>"
                  +"<span style=\"color:#000000;\"><img alt=\"\" height=\"250\" src=\"cid:").append(idGrafico).append("\" style=\"float: center;\" width=\"430\" /></span><br />"
        //area do grafico
         +"<p>"
                  +"&nbsp;</p>"
         +"<p style=\"color: blue;\">"
                  +"<em style=\"color: rgb(0, 0, 0);\">Est&aacute; tudo aqui em baixo, olha s&oacute; isso...</em></p>"
         +"<p style=\"color: blue;\">"
                  +"<span style=\"color:#000000;\">").append(mensagem).append("</span></p>"
         +"<p style=\"color: blue;\">"
                  +"<span style=\"color:#000000;\"><em>Estranho...</em></span></p>"
         +"<p style=\"color: blue;\">"
                  +"<br />"
                  +"<span style=\"color:#000000;\">Ent&atilde;o! Poderia fazer um favor pra mim?<br />"
                  +"Veja o que &eacute; voc&ecirc; recebeu e finalize no sistema <u><em><strong>Controle de Processos!</strong></em></u><br />"
                  +"Ah &eacute;! Ele fica bem na sua area de trabalho,<br />"
                  +"<em>Alias, tudo aqui est&aacute; relacionado a voc&ecirc;,</em> <span style=\"background-color:#ffff00;\">se n&atilde;o recebeu ou era pra outra pessoa voc&ecirc; pode contestar atraves da op&ccedil;&atilde;o Contestar</span>.<br />"
                  +"<br />"
                  +"Nunca ignore minhas mensagens, s&atilde;o importantes!<br />"
                  +"Se precisar de mais detalhes tem anexo viu? Muito obrigado e bom trabalho :)</span><br />"
                  +"<br />"
                  +"<span style=\"color:#808080;\"><em>***Ah! Outra coisa...n&atilde;o responde esse e-mail, por favor.***&nbsp;</em></span></p>"
            );
        
        EmailAttachment anexo = new EmailAttachment();
        anexo.setPath(arquivo);//pegando o anexo
        anexo.setDisposition(EmailAttachment.ATTACHMENT);
        anexo.setName("Relatorio.pdf");//renomeando o arquivo pdf
        
        email.attach(anexo);
        
        email.setHtmlMsg( builder.toString()+"\n");
        email.addTo(user.getEmail());
        //email.addTo(user.getEmail());
        email.send();
        
        System.out.println("Sucesso!");
        //model.setMensagem(user.getNome()+"=Email enviado com sucesso!");
        return true;
    } catch (EmailException e) {
        //model.setMensagem(user.getNome()+"=Falha ao enviar o email, problema no arquivo gerado!");
        return false;
    } 
    }
}
//package rblasch.Mail;

/**
 * Contains <em>Main</em>.
 *
 * <p>This is my solution of program assignment #2.  The documentation can be
 * found at <a href="http://www.cosy.sbg.ac.at/~rblasch/study/cs629/pa2/">
 * http://www.cosy.sbg.ac.at/~rblasch/study/cs629/pa2/</a>.</p>

 * @author Ronald Blaschke &lt;rblasch@cs.bgsu.edu&gt;
 * @version 1.0
 */
public class Client2
{
  /**
   * Main for a very simple SMTP client.
   *
   * <p>Usage is:
   * <tt>java Client2 &lt;server_name&gt; &lt;server_port&gt; &lt;message
   * sender&gt; &lt;Message receiver&gt; &lt;message&gt;</tt></p>
   *
   * <dl>
   *   <dt>server_name
   *   <dd>Name of the host where the SMTP server is running.
   *   <dt>server_port
   *   <dd>Port number of the SMTP server (25).  
   *   <dt>message_sender
   *   <dd>email address of mail sender
   *   <dt>message_receiver
   *   <dd>email address of mail receiver
   *   <dt>message
   *   <dd>The message to send.
   * </dl>
   *
   * <p>The debugFlag of the SmtpMail class is turned on.</p>
   *
   * <h2>Sample in/output (with debug info)</h2>
   * <p><pre>
alpha 103% java Client2 conductor.cs.bgsu.edu 25 'rblasch@cs.bgsu.edu' 'rblasch@cs.bgsu.edu' "MFG to me!"
D:trying to connect to server
D:connected
D:response: 220 conductor.cs.bgsu.edu ESMTP Sendmail 8.9.1/8.9.1; Sun, 3 Oct 1999 01:50:33 -0400 (EDT)
D:sending command: HELO alpha.bgsu.edu
D:response: 250 conductor.cs.bgsu.edu Hello alpha.bgsu.edu [129.1.2.12], pleased to meet you
D:sending command: MAIL from: rblasch@cs.bgsu.edu
D:response: 250 rblasch@cs.bgsu.edu... Sender ok
D:sending command: RCPT to: <rblasch@cs.bgsu.edu>
D:response: 250 <rblasch@cs.bgsu.edu>... Recipient ok
D:sending command: DATA
D:response: 354 Enter mail, end with "." on a line by itself
D:MFG to me!
D:.
D:response: 250 BAA23326 Message accepted for delivery
D:sending command: QUIT
D:response: 221 conductor.cs.bgsu.edu closing connection
   * </pre></p>
   *
   * @author Ronald Blaschke &lt;rblasch@cs.bgsu.edu&gt;
   * @version 1.0
   */
  public static void main(String[] argv)
  {
    if (argv.length < 5) {
      System.out.println("usage: java Client2 <server_name> <server_port> " +
			 "<message sender> <message receiver> <message>");
      System.exit(1);
    }

    String serverName = argv[0];
    int serverPort = Integer.parseInt(argv[1]);
    MailAddress sender = MailAddress.parseAddress(argv[2]);
    MailAddress receiver = MailAddress.parseAddress(argv[3]);
    String msg = argv[4];

    SmtpMail smtp = new SmtpMail();
    smtp.debugMode(true);
    try {
      smtp.simpleSend(serverName, serverPort, sender, receiver, 
		      "Mail from Client2", msg);
    }
    catch (Exception e) {
      System.err.println("Error while sending: " + e.toString());
      System.exit(1);
    }

    System.exit(0);
  }
}


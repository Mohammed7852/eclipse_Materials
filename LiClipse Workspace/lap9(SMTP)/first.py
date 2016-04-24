import smtplib , functools
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

sender = 'm.alishabanah2017@gmail.com'
password = "******"

to ={'shabanah825@hotmail.com' , 'm.alishabanah2017@gmai.com' , 'm.a.shabanah@stud.fci-cu.edu.eg'}

message = """From: Sender_name <m.alishabanah2017@gmail.com>
To: To Receiver_name <m.alishabanah2017@gmail.com>
Subject: trying message !

heyeheyeheyeheyeehye  hhhhh  !
your mails were hacked ,, donnot kid with me , i will kill you  :(
http://www.python.org
"""





html = """
<html>
  <head></head>
  <body>
    <p>Hi!<br>
       How are you?<br>
       Here is the <a href="http://www.facebook.com">face book link</a> you wanted.
    </p>
  </body>
</html>
"""


message =MIMEText(html, 'html')














server = smtplib.SMTP('smtp.gmail.com',587)
server.ehlo()
server.starttls()
server.login(sender, password)

try:
   server.sendmail(sender, to, message.as_string())         
   print ("Successfully sent email")
except:
   print ("Error: unable to send email")
server.quit()

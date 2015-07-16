import cgi
from google.appengine.api import users
import webapp2
import urllib

MAIN_PAGE_HTML = """\
<html>
  <body>
    <title>Yirui.STEP15.week7HW</title>
    <h1>Hello there, how are you today? <br> Hope you enjoy GAE this week! <3 </h1>
    <p><a href='/show?msg='>/show?msg=</a><p><br>
    <p><a href='/getword?pos='>/getword?pos=</a><p><br>
    <p><a href='/madlib'>/madlib</a><p><br>
    <form action="/convert" method="get">
      <div><textarea name="message" rows="3" cols="60"></textarea></div>
      <div><input type="submit" value="Convert Message"></div>
    </form><br>
  </body>
</html>
"""

class MainPage(webapp2.RequestHandler):
    def get(self):
        self.response.write(MAIN_PAGE_HTML)

class convertM(webapp2.RequestHandler):
    def get(self):
        Msg = self.request.get('message')
        self.response.write(cgi.escape(''.join(str(ord(c)) for c in Msg)))

class showM(webapp2.RequestHandler):
    def get(self):
        msg = self.request.get('msg')
        url = "http://step15-krispop.appspot.com/peers"
        getURL = urllib.urlopen(url)
        URLs = getURL.readlines()
        for lines in URLs:
            line = lines.strip()+'/convert?message='+ '\n' + msg.strip()
            self.response.write(line+' => ')
            msgs = urllib.urlopen(line)
            self.response.write(msgs.read()+'</br>' + '<br>')

class getWord(webapp2.RequestHandler):
    def get(self):
        w = self.request.get('pos')
        word_dic = { 'noun':'Pluto', 'verb':'feel', 'adjective':'priceless', 'adverb':'hopefully'}
        if w in word_dic:
            self.response.write(d[w])


app = webapp2.WSGIApplication([
    ('/', MainPage),
    ('/convert', convertM),
    ('/show', showM)
    ('/getword', getWord)
], debug=True)

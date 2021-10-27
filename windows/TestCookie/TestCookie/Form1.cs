using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Net;

namespace TestCookie
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void getCookie(string url)
        {
            // https://www.codeproject.com/Questions/1211097/How-do-I-get-ALL-cookies-from-a-website-instead-of
            // https://docs.microsoft.com/en-us/dotnet/api/system.net.cookiecontainer?redirectedfrom=MSDN&view=net-5.0

            try
            {

                HttpWebRequest myCall = (HttpWebRequest)WebRequest.Create(url);
                myCall.CookieContainer = new CookieContainer();

                HttpWebResponse response = (HttpWebResponse)myCall.GetResponse();
                myCall.AllowAutoRedirect = true;

                foreach (Cookie cookie in response.Cookies)
                {
                    textBoxListCookie.Text = textBoxListCookie.Text + Environment.NewLine + "URL: " + url;
                    textBoxListCookie.Text = textBoxListCookie.Text + Environment.NewLine + "Domain: " + cookie.Domain;
                    textBoxListCookie.Text = textBoxListCookie.Text + Environment.NewLine + "Cookie: " + cookie.Name;
                    textBoxListCookie.Text = textBoxListCookie.Text + Environment.NewLine + "Value: " + cookie.Value;
                    textBoxListCookie.Text = textBoxListCookie.Text + Environment.NewLine;
                    textBoxListCookie.Update();
                }
                myCall.Abort();
            }
            catch (Exception ex)
            {
                textBoxListCookie.Text = ex.Message;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // https://professorweb.ru/my/csharp/web/level7/7_4.php
            // https://qna.habr.com/q/366420
            //Cookie cookie = new Cookie("MyName", "Alex", "/", "localhost");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listBoxURLs.Items.Add(textBoxURL.Text);
            textBoxURL.Text = "";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            listBoxURLs.Items.RemoveAt(listBoxURLs.SelectedIndex);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            listBoxURLs.Items.Clear();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            toolStripStatusLabelInfo.Text = "Процесс запущен...";
            textBoxListCookie.Text = "";
            foreach (string url in listBoxURLs.Items)
            {
                getCookie(url);
            }
            toolStripStatusLabelInfo.Text = "...";
        }

        private void получитьСписокCookieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            toolStripStatusLabelInfo.Text = "Процесс запущен...";
            textBoxListCookie.Text = "";
            foreach (string url in listBoxURLs.Items)
            {
                getCookie(url);
            }
            toolStripStatusLabelInfo.Text = "...";
        }
        
        private void закрытьПрограммуToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            toolStripStatusLabelInfo.Text = "Процесс запущен...";
            textBoxListCookie.Text = "";
            foreach (string url in listBoxURLs.Items)
            {
                getCookie(url);
            }
            toolStripStatusLabelInfo.Text = "...";
        }

        private void оПрограммеToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //AboutForm about = new AboutForm();
            //about.ShowDialog();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {

        }
    }
}

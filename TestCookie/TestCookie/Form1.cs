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

        private void Form1_Load(object sender, EventArgs e)
        {
            // https://professorweb.ru/my/csharp/web/level7/7_4.php
            // https://qna.habr.com/q/366420
            Cookie cookie = new Cookie("MyName", "Alex", "/", "localhost");
        }
    }
}

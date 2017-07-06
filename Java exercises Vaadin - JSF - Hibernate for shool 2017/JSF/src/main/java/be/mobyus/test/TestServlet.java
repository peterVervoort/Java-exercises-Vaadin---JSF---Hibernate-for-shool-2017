package be.mobyus.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO add annotation to make this class discoverable as Servlet under path 'testServlet'
//See: https://blogs.oracle.com/swchan/entry/servlet_3_0_annotations
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		//TODO write some data to the output writer
	}
}

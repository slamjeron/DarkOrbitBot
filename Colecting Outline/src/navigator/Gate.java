package navigator;

import java.awt.Point;

public class Gate {
	private Point[][] cjumpgate2 =new Point[][]{{new Point(44,62),new Point(194,62),
		new Point(194,148),new Point(44,148)},{new Point(172+20,25+44),
			new Point(198,98),new Point(172+20,200+44),new Point(39,98)},{			
				new Point(181+20,112+44),new Point(64+20,112+44),new Point(239+20,11+44),
				new Point(239+20,209+44),new Point(166+20,112+44),new Point(188+20,99+44),
				new Point(188+20,121+44)},{new Point(239+20,213+44),new Point(107+20,110+44),
					new Point(214+20,52+44),new Point(214+20,172+44)},
					{new Point(312+20,56+44),new Point(52+20,56+44),new Point(52+20,181+44)
						,new Point(324+20,55+44),new Point(308+20,116+44),new Point(247,116+44)
						,new Point(247+20,137+44),new Point(300+20,137+44),new Point(300+20,211+44)
					}};
	public void mapSmall(){
		 cjumpgate2 =new Point[][]{{new Point(44,62),new Point(194,62),
				new Point(194,148),new Point(44,148)},{new Point(172+20,25+44),
					new Point(198,98),new Point(172+20,200+44),new Point(39,98)},{			
						new Point(181+20,112+44),new Point(64+20,112+44),new Point(239+20,11+44),
						new Point(239+20,209+44),new Point(166+20,112+44),new Point(188+20,99+44),
						new Point(188+20,121+44)},{new Point(239+20,213+44),new Point(107+20,110+44),
							new Point(214+20,52+44),new Point(214+20,172+44)},
							{new Point(312+20,56+44),new Point(52+20,56+44),new Point(52+20,181+44)
								,new Point(324+20,55+44),new Point(308+20,116+44),new Point(247,116+44)
								,new Point(247+20,137+44),new Point(300+20,137+44),new Point(300+20,211+44)
							}};
	}
	public final Point TOP_RIGHT = cjumpgate2[0][1]
			,TOP_LEFT=cjumpgate2[0][0]
					,BOTOM_LEFT=cjumpgate2[0][3]
							;
	public final Point BOTOM_RIGHT=cjumpgate2[0][2];
	
	public final Point CENTER_TOP = cjumpgate2[1][0]
			,CENTER_RIGHT=cjumpgate2[1][1]
					,CENTER_BOTOM=cjumpgate2[1][2]
							,CENTER_LEFT=cjumpgate2[1][3];
	
	
}

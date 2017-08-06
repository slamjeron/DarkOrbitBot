package mapControls;

import java.awt.Point;

public class Gate {
	private static Point[][] cjumpgate2 ={{new Point(39,33),new Point(314,33),
		new Point(314,191),new Point(39,191)},{new Point(172,25),
			new Point(322,100),new Point(172,200),new Point(31,100)},{			
				new Point(181,112),new Point(64,112),new Point(239,11),
				new Point(239,209),new Point(166,112),new Point(188,99),
				new Point(188,121)},{new Point(239,213),new Point(107,110),
					new Point(214,52),new Point(214,172)},
					{new Point(312,56),new Point(52,56),new Point(52,181)
						,new Point(324,55),new Point(308,116),new Point(247,116)
						,new Point(247,137),new Point(300,137),new Point(300,211)
					}};
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

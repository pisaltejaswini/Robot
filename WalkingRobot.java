package com.mahajan.HibernateFirst;

/**
 * Walking Robot
 *
 */
public class WalkingRobot 
{
	public static void main(String[] args) {
		// Input parameters
		int x = 5;  //Coordinates
		int y = 2;
		String command = "RLW2RRW4";
		String inDirection = "SOUTH";

		// Implementation
		WalkingRobot.Direction dir = Direction.valueOf(inDirection);
		char[] chrs = command.toCharArray();
		for (char ch : chrs) {
			if (ch == 'R') {
				int ord = dir.ordinal();
				int a = ord + 1;
				dir = WalkingRobot.Direction.values()[a > 3 ? 0 : a];
			} else if (ch == 'L') {
				int ord = dir.ordinal();
				int a = ord - 1;
				dir = WalkingRobot.Direction.values()[a < 0 ? 3 : a];
			} else if (ch == 'W') {
				continue;
			} else {
				if (dir == WalkingRobot.Direction.NORTH) {
					y = y + Integer.parseInt(ch + "");
				} else if (dir == WalkingRobot.Direction.EAST) {
					x = x + Integer.parseInt(ch + "");
				} else if (dir == WalkingRobot.Direction.SOUTH) {
					y = y - Integer.parseInt(ch + "");
				} else if (dir == WalkingRobot.Direction.WEST) {
					x = x - Integer.parseInt(ch + "");
				}
			}
		}

		System.out.println("FINAL : x : " + x + " , y : " + y + " and direction : " + dir);
	}

	enum Direction {
		NORTH, EAST, SOUTH, WEST;

	}
}

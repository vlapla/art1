/**
 * Created by vlado on 06.03.17.
 *
 *  Life1 - a simple version of John Horton Conway's Game of Life for learning (esp. of testing)
 *
    Copyright (C) 2017 Vlado Plaga

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class Life1 {
    private static final int HEIGHT = 10;
    private static final int WIDTH = 20;

    public static void main(String[] args) {
        LifeSim sim = new LifeSim(WIDTH, HEIGHT);
//        sim.print();
        sim.initSmallExploder();
        sim.print();
        for (int i = 0; i < 5; i++) {
            sim.step();
            sim.print();
        }

    }

}

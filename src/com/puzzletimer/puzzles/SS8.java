package com.puzzletimer.puzzles;

import java.awt.Color;
import java.util.HashMap;

import com.puzzletimer.graphics.Matrix44;
import com.puzzletimer.graphics.Mesh;
import com.puzzletimer.graphics.Plane;
import com.puzzletimer.graphics.Vector3;
import com.puzzletimer.models.ColorScheme;
import com.puzzletimer.models.PuzzleInfo;

public class SS8 implements Puzzle {
    @Override
    public PuzzleInfo getPuzzleInfo() {
        return new PuzzleInfo("8x8x8-CUBE");
    }

    @Override
    public String toString() {
        return getPuzzleInfo().getDescription();
    }

    private class Twist {
        public Plane plane;
        public double angle;

        public Twist(Plane plane, double angle) {
            this.plane = plane;
            this.angle = angle;
        }
    }

    @Override
    public Mesh getScrambledPuzzleMesh(ColorScheme colorScheme, String[] sequence) {
        Color[] colorArray = {
            colorScheme.getFaceColor("FACE-L").getColor(),
            colorScheme.getFaceColor("FACE-B").getColor(),
            colorScheme.getFaceColor("FACE-D").getColor(),
            colorScheme.getFaceColor("FACE-R").getColor(),
            colorScheme.getFaceColor("FACE-F").getColor(),
            colorScheme.getFaceColor("FACE-U").getColor(),
        };

        Mesh mesh = Mesh.cube(colorArray);

        Plane planeL  = new Plane(new Vector3(-0.3750, 0, 0), new Vector3(-1, 0, 0));
        Plane planeL2 = new Plane(new Vector3(-0.2500, 0, 0), new Vector3(-1, 0, 0));
        Plane planeL3 = new Plane(new Vector3(-0.1250, 0, 0), new Vector3(-1, 0, 0));
        Plane planeL4 = new Plane(new Vector3(-0.0000, 0, 0), new Vector3(-1, 0, 0));
        Plane planeR4 = new Plane(new Vector3( 0.0000, 0, 0), new Vector3( 1, 0, 0));
        Plane planeR3 = new Plane(new Vector3( 0.1250, 0, 0), new Vector3( 1, 0, 0));
        Plane planeR2 = new Plane(new Vector3( 0.2500, 0, 0), new Vector3( 1, 0, 0));
        Plane planeR  = new Plane(new Vector3( 0.3750, 0, 0), new Vector3( 1, 0, 0));
        Plane planeD  = new Plane(new Vector3(0, -0.3750, 0), new Vector3(0, -1, 0));
        Plane planeD2 = new Plane(new Vector3(0, -0.2500, 0), new Vector3(0, -1, 0));
        Plane planeD3 = new Plane(new Vector3(0, -0.1250, 0), new Vector3(0, -1, 0));
        Plane planeD4 = new Plane(new Vector3(0, -0.0000, 0), new Vector3(0, -1, 0));
        Plane planeU4 = new Plane(new Vector3(0,  0.0000, 0), new Vector3(0,  1, 0));
        Plane planeU3 = new Plane(new Vector3(0,  0.1250, 0), new Vector3(0,  1, 0));
        Plane planeU2 = new Plane(new Vector3(0,  0.2500, 0), new Vector3(0,  1, 0));
        Plane planeU  = new Plane(new Vector3(0,  0.3750, 0), new Vector3(0,  1, 0));
        Plane planeF  = new Plane(new Vector3(0, 0, -0.3750), new Vector3(0, 0, -1));
        Plane planeF2 = new Plane(new Vector3(0, 0, -0.2500), new Vector3(0, 0, -1));
        Plane planeF3 = new Plane(new Vector3(0, 0, -0.1250), new Vector3(0, 0, -1));
        Plane planeF4 = new Plane(new Vector3(0, 0, -0.0000), new Vector3(0, 0, -1));
        Plane planeB4 = new Plane(new Vector3(0, 0,  0.0000), new Vector3(0, 0,  1));
        Plane planeB3 = new Plane(new Vector3(0, 0,  0.1250), new Vector3(0, 0,  1));
        Plane planeB2 = new Plane(new Vector3(0, 0,  0.2500), new Vector3(0, 0,  1));
        Plane planeB  = new Plane(new Vector3(0, 0,  0.3750), new Vector3(0, 0,  1));

        mesh = mesh
            .cut(planeL,  0)
            .cut(planeL2, 0)
            .cut(planeL3, 0)
            .cut(planeL4, 0)
            .cut(planeR3, 0)
            .cut(planeR2, 0)
            .cut(planeR,  0)
            .cut(planeD,  0)
            .cut(planeD2, 0)
            .cut(planeD3, 0)
            .cut(planeD4, 0)
            .cut(planeU3, 0)
            .cut(planeU2, 0)
            .cut(planeU,  0)
            .cut(planeF,  0)
            .cut(planeF2, 0)
            .cut(planeF3, 0)
            .cut(planeF4, 0)
            .cut(planeB3, 0)
            .cut(planeB2, 0)
            .cut(planeB,  0)
            .shortenFaces(0.0175)
            .softenFaces(0.01)
            .softenFaces(0.005);

        HashMap<String, Twist> twists = new HashMap<String, Twist>();
        twists.put("L",   new Twist(planeL,   Math.PI / 2));
        twists.put("2L",  new Twist(planeL2,  Math.PI / 2));
        twists.put("3L",  new Twist(planeL3,  Math.PI / 2));
        twists.put("4L",  new Twist(planeL4,  Math.PI / 2));
        twists.put("L2",  new Twist(planeL,   Math.PI));
        twists.put("2L2", new Twist(planeL2,  Math.PI));
        twists.put("3L2", new Twist(planeL3,  Math.PI));
        twists.put("4L2", new Twist(planeL4,  Math.PI));
        twists.put("L'",  new Twist(planeL,  -Math.PI / 2));
        twists.put("2L'", new Twist(planeL2, -Math.PI / 2));
        twists.put("3L'", new Twist(planeL3, -Math.PI / 2));
        twists.put("4L'", new Twist(planeL4, -Math.PI / 2));
        twists.put("R",   new Twist(planeR,   Math.PI / 2));
        twists.put("2R",  new Twist(planeR2,  Math.PI / 2));
        twists.put("3R",  new Twist(planeR3,  Math.PI / 2));
        twists.put("4R",  new Twist(planeR4,  Math.PI / 2));
        twists.put("R2",  new Twist(planeR,   Math.PI));
        twists.put("2R2", new Twist(planeR2,  Math.PI));
        twists.put("3R2", new Twist(planeR3,  Math.PI));
        twists.put("4R2", new Twist(planeR4,  Math.PI));
        twists.put("R'",  new Twist(planeR,  -Math.PI / 2));
        twists.put("2R'", new Twist(planeR2, -Math.PI / 2));
        twists.put("3R'", new Twist(planeR3, -Math.PI / 2));
        twists.put("4R'", new Twist(planeR4, -Math.PI / 2));
        twists.put("D",   new Twist(planeD,   Math.PI / 2));
        twists.put("2D",  new Twist(planeD2,  Math.PI / 2));
        twists.put("3D",  new Twist(planeD3,  Math.PI / 2));
        twists.put("4D",  new Twist(planeD4,  Math.PI / 2));
        twists.put("D2",  new Twist(planeD,   Math.PI));
        twists.put("2D2", new Twist(planeD2,  Math.PI));
        twists.put("3D2", new Twist(planeD3,  Math.PI));
        twists.put("4D2", new Twist(planeD4,  Math.PI));
        twists.put("D'",  new Twist(planeD,  -Math.PI / 2));
        twists.put("2D'", new Twist(planeD2, -Math.PI / 2));
        twists.put("3D'", new Twist(planeD3, -Math.PI / 2));
        twists.put("4D'", new Twist(planeD4, -Math.PI / 2));
        twists.put("U",   new Twist(planeU,   Math.PI / 2));
        twists.put("2U",  new Twist(planeU2,  Math.PI / 2));
        twists.put("3U",  new Twist(planeU3,  Math.PI / 2));
        twists.put("4U",  new Twist(planeU4,  Math.PI / 2));
        twists.put("U2",  new Twist(planeU,   Math.PI));
        twists.put("2U2", new Twist(planeU2,  Math.PI));
        twists.put("3U2", new Twist(planeU3,  Math.PI));
        twists.put("4U2", new Twist(planeU4,  Math.PI));
        twists.put("U'",  new Twist(planeU,  -Math.PI / 2));
        twists.put("2U'", new Twist(planeU2, -Math.PI / 2));
        twists.put("3U'", new Twist(planeU3, -Math.PI / 2));
        twists.put("4U'", new Twist(planeU4, -Math.PI / 2));
        twists.put("F",   new Twist(planeF,   Math.PI / 2));
        twists.put("2F",  new Twist(planeF2,  Math.PI / 2));
        twists.put("3F",  new Twist(planeF3,  Math.PI / 2));
        twists.put("4F",  new Twist(planeF4,  Math.PI / 2));
        twists.put("F2",  new Twist(planeF,   Math.PI));
        twists.put("2F2", new Twist(planeF2,  Math.PI));
        twists.put("3F2", new Twist(planeF3,  Math.PI));
        twists.put("4F2", new Twist(planeF4,  Math.PI));
        twists.put("F'",  new Twist(planeF,  -Math.PI / 2));
        twists.put("2F'", new Twist(planeF2, -Math.PI / 2));
        twists.put("3F'", new Twist(planeF3, -Math.PI / 2));
        twists.put("4F'", new Twist(planeF4, -Math.PI / 2));
        twists.put("B",   new Twist(planeB,   Math.PI / 2));
        twists.put("2B",  new Twist(planeB2,  Math.PI / 2));
        twists.put("3B",  new Twist(planeB3,  Math.PI / 2));
        twists.put("4B",  new Twist(planeB4,  Math.PI / 2));
        twists.put("B2",  new Twist(planeB,   Math.PI));
        twists.put("2B2", new Twist(planeB2,  Math.PI));
        twists.put("3B2", new Twist(planeB3,  Math.PI));
        twists.put("4B2", new Twist(planeB4,  Math.PI));
        twists.put("B'",  new Twist(planeB,  -Math.PI / 2));
        twists.put("2B'", new Twist(planeB2, -Math.PI / 2));
        twists.put("3B'", new Twist(planeB3, -Math.PI / 2));
        twists.put("4B'", new Twist(planeB4, -Math.PI / 2));

        for (String move : sequence) {
            Twist t = twists.get(move);
            mesh = mesh.rotateHalfspace(t.plane, t.angle);
        }

        return mesh
            .transform(Matrix44.rotationY(-Math.PI / 6))
            .transform(Matrix44.rotationX(Math.PI / 7));
    }
}

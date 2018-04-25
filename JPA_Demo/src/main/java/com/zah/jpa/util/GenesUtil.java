package com.zah.jpa.util;

import com.zah.jpa.data.GeneType;
import com.zah.jpa.entity.Genes;

import java.util.Random;

/**
 * Created by zah on 2018/4/10.
 */
public class GenesUtil {

    public static Genes createGenes(int generation) {
        Genes genes = new Genes();
        if (generation == 0) {
            int[] geneType = randomInts(new Random());
            genes.setG0_shape_type(GeneType.values()[geneType[0]]);
            genes.setG0_color_type(GeneType.values()[geneType[1]]);

            genes.setG1_shape_type(GeneType.values()[geneType[2]]);
            genes.setG1_color_type(GeneType.values()[geneType[3]]);

            genes.setG2_shape_type(GeneType.values()[geneType[4]]);
            genes.setG2_color_type(GeneType.values()[geneType[5]]);

            genes.setG3_shape_type(GeneType.values()[geneType[6]]);
            genes.setG3_color_type(GeneType.values()[geneType[7]]);
        }

        return genes;
    }

    public static int[] randomInts(Random random) {
        int[] geneType = new int[8];
        int count = 0;
        for (int i = 0; i < geneType.length; i++) {
            int v = random.nextInt(2);
            geneType[i] = v;
            count += v;
        }
        if (count != 4) {
            geneType = randomInts(random);
        }
        return geneType;
    }
}

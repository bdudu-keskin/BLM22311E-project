/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bdudu_keskin_2221221003;

import java.util.*;

/**
 * 
 *
 * @author Asus
 */
public class BDudu_Keskin_2221221003 {

    static int[][] sparseTable;
    static int[] blockMins;
    static int blockSize;
    
    public static void main(String[] args) {

        //creating arrs and ranges
        int[] arrTest = generateRandomArrayNonRepetitive(10, 100) ;
        int[] sTest = sorted(arrTest);
        int[] revTest = reverseSorted(arrTest);

        int[] arr100 = generateRandomArrayNonRepetitive(100, 300);
        int[] arr300 = generateRandomArrayNonRepetitive(300, 900);
        int[] arr500 = generateRandomArrayNonRepetitive(500, 1500);
        int[] arr1k = generateRandomArrayNonRepetitive(1000, 3000);
        int[] arr3k = generateRandomArrayNonRepetitive(3000, 9000);
        int[] arr5k = generateRandomArrayNonRepetitive(5000, 15000);
        int[] arr10k = generateRandomArrayNonRepetitive(10000, 30000);
        int[] arr12k = generateRandomArrayNonRepetitive(12000, 45000);

        int[] sorted100 = sorted(arr100);
        int[] sorted300 = sorted(arr300);
        int[] sorted500 = sorted(arr500);
        int[] sorted1k = sorted(arr1k);
        int[] sorted3k = sorted(arr3k);
        int[] sorted5k = sorted(arr5k);
        int[] sorted10k = sorted(arr10k);
        int[] sorted12k = sorted(arr12k);
        
        int[] rev100 = reverseSorted(sorted100);
        int[] rev300 = reverseSorted(sorted300);
        int[] rev500 = reverseSorted(sorted500);
        int[] rev1k = reverseSorted(sorted1k);
        int[] rev3k = reverseSorted(sorted3k);
        int[] rev5k = reverseSorted(sorted5k);
        int[] rev10k = reverseSorted(sorted10k);
        int[] rev12k = reverseSorted(sorted12k);

//------------------------------------------------------------------------------

        //testing the methods
        precomputeNone(arrTest, 0 ,4);
        precomputeNone(sTest, 0 ,4);
        precomputeNone(revTest, 0 ,4);
        
        long testStartPA = System.nanoTime();
        int[][] minTableTest = precomputeAll(arrTest);
        long testEndPA = System.nanoTime();        
        System.out.println("\nPreprocessing Time: " + (testEndPA - testStartPA) + " ns");
        minQueryPA(minTableTest, 0, 4);
        
        long stestStartPA = System.nanoTime();
        int[][] sminTableTest = precomputeAll(sTest);
        long stestEndPA = System.nanoTime();        
        System.out.println("\npreprocessing Time: " + (stestEndPA - stestStartPA) + " ns");
        minQueryPA(sminTableTest, 0, 4);
        
        long testStartST = System.nanoTime();
        sparseTable(arrTest);
        long testEndST = System.nanoTime();
        System.out.println("\nSparse Table Preprocessing Time: " + (testEndST - testStartST) + " ns");
        minQueryST(0, 4);
        
        long testStartBlock = System.nanoTime();
        blocking(arrTest, (int)Math.sqrt(arrTest.length));
        long testEndBlock = System.nanoTime();
        System.out.println("Blocking Preprocessing Time: " + (testEndBlock - testStartBlock) + " ns");
        minQueryBlock(arrTest, 0, 4);
       
        System.out.println("");
        System.out.println("-----------------------------------------------");
//------------------------------------------------------------------------------        
        
        //precompute none
        
        //random
        precomputeNone(arr100, 0, 99);
        precomputeNone(arr300, 0, 299);
        precomputeNone(arr500, 0, 499);
        precomputeNone(arr1k, 0, 999);
        precomputeNone(arr3k, 0, 2999);
        precomputeNone(arr5k, 0, 4999);
        precomputeNone(arr10k, 0, 9999);
        precomputeNone(arr12k, 0, 11999);
        
        System.out.println("");
        
        //sorted
        precomputeNone(sorted100, 0, 99);
        precomputeNone(sorted300, 0, 299);
        precomputeNone(sorted500, 0, 499);
        precomputeNone(sorted1k, 0, 999);
        precomputeNone(sorted3k, 0, 2999);
        precomputeNone(sorted5k, 0, 4999);
        precomputeNone(sorted10k, 0, 9999);
        precomputeNone(sorted12k, 0, 11999);
                
        System.out.println("");
        
        //reverse
        precomputeNone(rev100, 0, 99);
        precomputeNone(rev300, 0, 299);
        precomputeNone(rev500, 0, 499);
        precomputeNone(rev1k, 0, 999);
        precomputeNone(rev3k, 0, 2999);
        precomputeNone(rev5k, 0, 4999);
        precomputeNone(rev10k, 0, 9999); 
        precomputeNone(rev12k, 0, 11999);
        
        System.out.println("");
        
//------------------------------------------------------------------------------
        
        //precompute all
        
        //random                
        long _100StartPA = System.nanoTime();
        int[][] minTable100 = precomputeAll(arr100);
        long _100EndPA = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_100EndPA - _100StartPA) + " ns");
        minQueryPA(minTable100, 0, 99);
        
        long _300StartPA = System.nanoTime();
        int[][] minTable300 = precomputeAll(arr300);
        long _300EndPA = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_300EndPA - _300StartPA) + " ns");
        minQueryPA(minTable300, 0, 299);
        
        long _500Start = System.nanoTime();
        int[][] minTable500 = precomputeAll(arr500);
        long _500End = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_500End - _500Start) + " ns");
        minQueryPA(minTable500, 0, 499);
        
        long _1kStart = System.nanoTime();
        int[][] minTable1k = precomputeAll(arr1k);
        long _1kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_1kEnd - _1kStart) + " ns");
        minQueryPA(minTable1k, 0, 999);
        
        long _3kStart = System.nanoTime();
        int[][] minTable3k = precomputeAll(arr3k);
        long _3kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_3kEnd - _3kStart) + " ns");
        minQueryPA(minTable3k, 0, 2999);
        
        long _5kStart = System.nanoTime();
        int[][] minTable5k = precomputeAll(arr5k);
        long _5kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_5kEnd - _5kStart) + " ns");
        minQueryPA(minTable5k, 0, 4999);
        
        long _10kStart = System.nanoTime();
        int[][] minTable10k = precomputeAll(arr10k);
        long _10kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_10kEnd - _10kStart) + " ns");
        minQueryPA(minTable10k, 0, 9999);
        
        long _12kStart = System.nanoTime();
        int[][] minTable12k = precomputeAll(arr12k);
        long _12kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (_12kEnd - _12kStart) + " ns");
        minQueryPA(minTable12k, 0, 11999);
        
        System.out.println("");
        
        //sorted                
        long s100StartPA = System.nanoTime();
        int[][] sminTable100 = precomputeAll(sorted100);
        long s100EndPA = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s100EndPA - s100StartPA) + " ns");
        minQueryPA(sminTable100, 0, 99);
        
        long s300StartPA = System.nanoTime();
        int[][] sminTable300 = precomputeAll(sorted300);
        long s300EndPA = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s300EndPA - s300StartPA) + " ns");
        minQueryPA(sminTable300, 0, 299);
        
        long s500Start = System.nanoTime();
        int[][] sminTable500 = precomputeAll(sorted500);
        long s500End = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s500End - s500Start) + " ns");
        minQueryPA(sminTable500, 0, 499);
        
        long s1kStart = System.nanoTime();
        int[][] sminTable1k = precomputeAll(sorted1k);
        long s1kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s1kEnd - s1kStart) + " ns");
        minQueryPA(sminTable1k, 0, 999);
        
        long s3kStart = System.nanoTime();
        int[][] sminTable3k = precomputeAll(sorted3k);
        long s3kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s3kEnd - s3kStart) + " ns");
        minQueryPA(sminTable3k, 0, 2999);
        
        long s5kStart = System.nanoTime();
        int[][]sminTable5k = precomputeAll(sorted5k);
        long s5kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s5kEnd - s5kStart) + " ns");
        minQueryPA(sminTable5k, 0, 4999);
        
        long s10kStart = System.nanoTime();
        int[][] sminTable10k = precomputeAll(sorted10k);
        long s10kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s10kEnd - s10kStart) + " ns");
        minQueryPA(sminTable10k, 0, 9999);
        
        long s12kStart = System.nanoTime();
        int[][] sminTable12k = precomputeAll(sorted12k);
        long s12kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (s12kEnd - s12kStart) + " ns");
        minQueryPA(sminTable12k, 0, 11999);
       
        System.out.println("");
        
        //reverse sorted                
        long r100StartPA = System.nanoTime();
        int[][] rminTable100 = precomputeAll(rev100);
        long r100EndPA = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r100EndPA - r100StartPA) + " ns");
        minQueryPA(rminTable100, 0, 99);
        
        long r300StartPA = System.nanoTime();
        int[][] rminTable300 = precomputeAll(rev300);
        long r300EndPA = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r300EndPA - r300StartPA) + " ns");
        minQueryPA(rminTable300, 0, 299);
        
        long r500Start = System.nanoTime();
        int[][] rminTable500 = precomputeAll(rev500);
        long r500End = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r500End - r500Start) + " ns");
        minQueryPA(rminTable500, 0, 499);
        
        long r1kStart = System.nanoTime();
        int[][] rminTable1k = precomputeAll(rev1k);
        long r1kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r1kEnd - r1kStart) + " ns");
        minQueryPA(rminTable1k, 0, 999);
        
        long r3kStart = System.nanoTime();
        int[][] rminTable3k = precomputeAll(rev3k);
        long r3kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r3kEnd - r3kStart) + " ns");
        minQueryPA(rminTable3k, 0, 2999);        
        
        long r5kStart = System.nanoTime();
        int[][]rminTable5k = precomputeAll(rev5k);
        long r5kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r5kEnd - r5kStart) + " ns");
        minQueryPA(rminTable5k, 0, 4999);
        
        long r10kStart = System.nanoTime();
        int[][] rminTable10k = precomputeAll(rev10k);
        long r10kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r10kEnd - r10kStart) + " ns");
        minQueryPA(rminTable10k, 0, 9999);
        
        long r12kStart = System.nanoTime();
        int[][] rminTable12k = precomputeAll(rev12k);
        long r12kEnd = System.nanoTime();        
        System.out.println("precompute all preproccesing time: " + (r12kEnd - r12kStart) + " ns");
        minQueryPA(rminTable12k, 0, 11999);
        
        System.out.println("");
        
//------------------------------------------------------------------------------          
        
        //sparse table
        
        //random        
        long _100StartST = System.nanoTime();
        sparseTable(arr100);
        long _100EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_100EndST - _100StartST) + " ns");
        minQueryST(0, 99);
        
        long _300StartST = System.nanoTime();
        sparseTable(arr300);
        long _300EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_300EndST - _300StartST) + " ns");
        minQueryST(0, 299);
        
        long _500StartST = System.nanoTime();
        sparseTable(arr500);
        long _500EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_500EndST - _500StartST) + " ns");
        minQueryST(0, 499);
        
        long _1kStartST = System.nanoTime();
        sparseTable(arr1k);
        long _1kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_1kEndST - _1kStartST) + " ns");
        minQueryST(0, 999);
        
        long _3kStartST = System.nanoTime();
        sparseTable(arr3k);
        long _3kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_3kEndST - _3kStartST) + " ns");
        minQueryST(0, 2999);
        
        long _5kStartST = System.nanoTime();
        sparseTable(arr5k);
        long _5kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_5kEndST - _5kStartST) + " ns");
        minQueryST(0, 4999);
        
        long _10kStartST = System.nanoTime();
        sparseTable(arr10k);
        long _10kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_10kEndST - _10kStartST) + " ns");
        minQueryST(0, 9999);
        
        long _12kStartST = System.nanoTime();
        sparseTable(arr12k);
        long _12kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (_12kEndST - _12kStartST) + " ns");
        minQueryST(0, 11999);
        
        System.out.println("");
        
        //sorted 
        long s100StartST = System.nanoTime();
        sparseTable(sorted100);
        long s100EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s100EndST - s100StartST) + " ns");
        minQueryST(0, 99);
        
        long s300StartST = System.nanoTime();
        sparseTable(sorted300);
        long s300EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s300EndST - s300StartST) + " ns");
        minQueryST(0, 299);
        
        long s500StartST = System.nanoTime();
        sparseTable(sorted500);
        long s500EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s500EndST - s500StartST) + " ns");
        minQueryST(0, 499);
        
        long s1kStartST = System.nanoTime();
        sparseTable(sorted1k);
        long s1kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s1kEndST - s1kStartST) + " ns");
        minQueryST(0, 999);
        
        long s3kStartST = System.nanoTime();
        sparseTable(sorted3k);
        long s3kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s3kEndST - s3kStartST) + " ns");
        minQueryST(0, 2999);
        
        long s5kStartST = System.nanoTime();
        sparseTable(sorted5k);
        long s5kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s5kEndST - s5kStartST) + " ns");
        minQueryST(0, 4999);
        
        long s10kStartST = System.nanoTime();
        sparseTable(sorted10k);
        long s10kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s10kEndST - s10kStartST) + " ns");
        minQueryST(0, 9999);
        
        long s12kStartST = System.nanoTime();
        sparseTable(sorted12k);
        long s12kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (s12kEndST - s12kStartST) + " ns");
        minQueryST(0, 11999);
        
        System.out.println("");
        
        //reverse sorted        
        long r100StartST = System.nanoTime();
        sparseTable(rev100);
        long r100EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r100EndST - r100StartST) + " ns");
        minQueryST(0, 99);
        
        long r300StartST = System.nanoTime();
        sparseTable(rev300);
        long r300EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r300EndST - r300StartST) + " ns");
        minQueryST(0, 299);
        
        long r500StartST = System.nanoTime();
        sparseTable(rev500);
        long r500EndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r500EndST - r500StartST) + " ns");
        minQueryST(0, 499);
        
        long r1kStartST = System.nanoTime();
        sparseTable(rev1k);
        long r1kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r1kEndST - r1kStartST) + " ns");
        minQueryST(0, 999);
        
        long r3kStartST = System.nanoTime();
        sparseTable(rev3k);
        long r3kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r3kEndST - r3kStartST) + " ns");
        minQueryST(0, 2999);
        
        long r5kStartST = System.nanoTime();
        sparseTable(rev5k);
        long r5kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r5kEndST - r5kStartST) + " ns");
        minQueryST(0, 4999);
        
        long r10kStartST = System.nanoTime();
        sparseTable(rev10k);
        long r10kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r10kEndST - r10kStartST) + " ns");
        minQueryST(0, 9999);
        
        long r12kStartST = System.nanoTime();
        sparseTable(rev12k);
        long r12kEndST = System.nanoTime();
        System.out.println("sparse table preproccesing time: " + (r12kEndST - r12kStartST) + " ns");
        minQueryST(0, 11999);
        
        System.out.println("");
        
//------------------------------------------------------------------------------        

        //blocking
        
        //random
        long _100StartBlock = System.nanoTime();
        blocking(arr100, (int)Math.sqrt(arr100.length));
        long _100EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_100EndBlock - _100StartBlock) + " ns");
        minQueryBlock(arr100, 0, 99);
        
        long _300StartBlock = System.nanoTime();
        blocking(arr300, (int)Math.sqrt(arr300.length));
        long _300EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_300EndBlock - _300StartBlock) + " ns");
        minQueryBlock(arr300, 0, 299);
        
        long _500StartBlock = System.nanoTime();
        blocking(arr500, (int)Math.sqrt(arr500.length));
        long _500EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_500EndBlock - _500StartBlock) + " ns");
        minQueryBlock(arr500, 0, 499);
        
        long _1kStartBlock = System.nanoTime();
        blocking(arr1k, (int)Math.sqrt(arr1k.length));
        long _1kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_1kEndBlock - _1kStartBlock) + " ns");
        minQueryBlock(arr1k, 0, 999);
        
        long _3kStartBlock = System.nanoTime();
        blocking(arr3k, (int)Math.sqrt(arr3k.length));
        long _3kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_3kEndBlock - _3kStartBlock) + " ns");
        minQueryBlock(arr3k, 0, 2999);
        
        long _5kStartBlock = System.nanoTime();
        blocking(arr5k, (int)Math.sqrt(arr5k.length));
        long _5kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_5kEndBlock - _5kStartBlock) + " ns");
        minQueryBlock(arr5k, 0, 4999);
        
        long _10kStartBlock = System.nanoTime();
        blocking(arr10k, (int)Math.sqrt(arr10k.length));
        long _10kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_10kEndBlock - _10kStartBlock) + " ns");
        minQueryBlock(arr10k, 0, 9999);
        
        long _12kStartBlock = System.nanoTime();
        blocking(arr12k, (int)Math.sqrt(arr12k.length));
        long _12kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (_12kEndBlock - _12kStartBlock) + " ns");
        minQueryBlock(arr12k, 0,11999);
        
        System.out.println("");
        
        //sorted        
        long s100StartBlock = System.nanoTime();
        blocking(sorted100, (int)Math.sqrt(arr100.length));
        long s100EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s100EndBlock - s100StartBlock) + " ns");
        minQueryBlock(sorted100, 0, 99);
        
        long s300StartBlock = System.nanoTime();
        blocking(sorted300, (int)Math.sqrt(arr300.length));
        long s300EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s300EndBlock - s300StartBlock) + " ns");
        minQueryBlock(sorted300, 0, 299);
        
        long s500StartBlock = System.nanoTime();
        blocking(arr500, (int)Math.sqrt(arr500.length));
        long s500EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s500EndBlock - s500StartBlock) + " ns");
        minQueryBlock(sorted500, 0, 499);
        
        long s1kStartBlock = System.nanoTime();
        blocking(sorted1k, (int)Math.sqrt(arr1k.length));
        long s1kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s1kEndBlock - s1kStartBlock) + " ns");
        minQueryBlock(sorted1k, 0, 999);
        
        long s3kStartBlock = System.nanoTime();
        blocking(sorted3k, (int)Math.sqrt(arr3k.length));
        long s3kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s3kEndBlock - s3kStartBlock) + " ns");
        minQueryBlock(sorted3k, 0, 2999);
        
        long s5kStartBlock = System.nanoTime();
        blocking(sorted5k, (int)Math.sqrt(arr5k.length));
        long s5kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s5kEndBlock - s5kStartBlock) + " ns");
        minQueryBlock(sorted5k, 0, 4999);
        
        long s10kStartBlock = System.nanoTime();
        blocking(sorted10k, (int)Math.sqrt(arr10k.length));
        long s10kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s10kEndBlock - s10kStartBlock) + " ns");
        minQueryBlock(sorted10k, 0, 9999);
        
        long s12kStartBlock = System.nanoTime();
        blocking(arr12k, (int)Math.sqrt(arr12k.length));
        long s12kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (s12kEndBlock - s12kStartBlock) + " ns");
        minQueryBlock(sorted12k, 0,11999);
        
        System.out.println("");
        
        //reverse sorted
        long r100StartBlock = System.nanoTime();
        blocking(rev100, (int)Math.sqrt(arr100.length));
        long r100EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r100EndBlock - r100StartBlock) + " ns");
        minQueryBlock(rev100, 0, 99);
        
        long r300StartBlock = System.nanoTime();
        blocking(rev300, (int)Math.sqrt(arr300.length));
        long r300EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r300EndBlock - r300StartBlock) + " ns");
        minQueryBlock(rev300, 0, 299);
        
        long r500StartBlock = System.nanoTime();
        blocking(rev500, (int)Math.sqrt(arr500.length));
        long r500EndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r500EndBlock - r500StartBlock) + " ns");
        minQueryBlock(rev500, 0, 499);
        
        long r1kStartBlock = System.nanoTime();
        blocking(rev1k, (int)Math.sqrt(arr1k.length));
        long r1kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r1kEndBlock - r1kStartBlock) + " ns");
        minQueryBlock(rev1k, 0, 999);
        
        long r3kStartBlock = System.nanoTime();
        blocking(sorted3k, (int)Math.sqrt(arr3k.length));
        long r3kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r3kEndBlock - r3kStartBlock) + " ns");
        minQueryBlock(rev3k, 0, 2999);
        
        long r5kStartBlock = System.nanoTime();
        blocking(rev5k, (int)Math.sqrt(arr5k.length));
        long r5kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r5kEndBlock - r5kStartBlock) + " ns");
        minQueryBlock(rev5k, 0, 4999);
        
        long r10kStartBlock = System.nanoTime();
        blocking(rev10k, (int)Math.sqrt(arr10k.length));
        long r10kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r10kEndBlock - r10kStartBlock) + " ns");
        minQueryBlock(rev10k, 0, 9999);
        
        long r12kStartBlock = System.nanoTime();
        blocking(rev12k, (int)Math.sqrt(arr12k.length));
        long r12kEndBlock = System.nanoTime();
        System.out.println("blocking preprocessing time: " + (r12kEndBlock - r12kStartBlock) + " ns");
        minQueryBlock(rev12k, 0,11999);
        
        System.out.println("");        
    }
   
    
    
    public static void precomputeNone(int[] arr, int L, int R) {
        
        long overallStart = System.nanoTime();

        int minValue = Integer.MAX_VALUE;

        // Compute the minimum in the range [L, R]
        for (int i = L; i <= R; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }

        System.out.println("minimum of range [" + L + ", " + R + "] is: " + minValue);

        long overallEnd = System.nanoTime();
        long totalDuration = overallEnd - overallStart;

        System.out.println("precompute none total query time: " + totalDuration + " ns");
    }
      
     public static int[][] precomputeAll(int[] arr) {
         
        int n = arr.length;

        // Create a 2D table to store range minimums
        int[][] minTable = new int[n][n];

        // Fill the table
        for (int L = 0; L < n; L++) {
            minTable[L][L] = arr[L]; // Minimum of a single element range is the element itself
            for (int R = L + 1; R < n; R++) {
                minTable[L][R] = Math.min(minTable[L][R - 1], arr[R]);
            }
        }
        return minTable;
    }
          
    public static void minQueryPA(int[][] minTable, int L, int R) {
        
        long queryStart = System.nanoTime();

        int minValue = minTable[L][R]; // Direct lookup in the precomputed table
        
        System.out.println("minimum of range [" + L + ", " + R + "] is: " + minValue);

        long queryEnd = System.nanoTime();
        long totalDuration = queryEnd - queryStart;

        System.out.println("precompute all total Query Time: " + totalDuration + " ns\n");
    }
    
    public static void sparseTable(int[] arr) {
        int n = arr.length;
        int k = (int) (Math.log(n) / Math.log(2)) + 1; // Max power of 2 needed

        sparseTable = new int[n][k];

        // Initialize for intervals of size 1
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }

        // Preprocess intervals with size 2^j
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1],
                                             sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }
        
    public static void minQueryST(int L, int R) {
        
        long queryStart = System.nanoTime();

        int j = (int) (Math.log(R - L + 1) / Math.log(2));

        int minValue = Math.min(sparseTable[L][j], sparseTable[R - (1 << j) + 1][j]);

        System.out.println("minimum of range [" + L + ", " + R + "] is: " + minValue);

        long queryEnd = System.nanoTime();
        long totalDuration = queryEnd - queryStart;
        System.out.println("sparse table total query time: " + totalDuration + " ns\n");
    }
    
    public static void blocking(int[] arr, int bSize) {
        
        blockSize = bSize;
        int n = arr.length;
        int numBlocks = (n + blockSize - 1) / blockSize;
        blockMins = new int[numBlocks];
        Arrays.fill(blockMins, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int blockIndex = i / blockSize;
            blockMins[blockIndex] = Math.min(blockMins[blockIndex], arr[i]);
        }
    }
   
    public static void minQueryBlock(int[] arr, int L, int R) {
        
        long queryStart = System.nanoTime();

        int minValue = Integer.MAX_VALUE;

        int startBlock = L / blockSize;
        int endBlock = R / blockSize;

        if (startBlock == endBlock) {
            for (int i = L; i <= R; i++) {
                minValue = Math.min(minValue, arr[i]);
            }
        } // Case 2: L and R are in different blocks
        else {
            // Check the first partial block
            for (int i = L; i < (startBlock + 1) * blockSize && i < arr.length; i++) {
                minValue = Math.min(minValue, arr[i]);
            }

            // Check fully covered blocks
            for (int block = startBlock + 1; block < endBlock && block < blockMins.length; block++) {
                minValue = Math.min(minValue, blockMins[block]);
            }

            // Check the last partial block
            for (int i = endBlock * blockSize; i <= R && i < arr.length; i++) {
                minValue = Math.min(minValue, arr[i]);
            }
        }

        System.out.println("minimum of range [" + L + ", " + R + "] is: " + minValue);

        long queryEnd = System.nanoTime();
        long totalDuration = queryEnd - queryStart;
        System.out.println("blocking total query time: " + totalDuration + " ns\n");
    }
   
    public static int[] generateRandomArrayNonRepetitive(int size, int range) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        // Keep generating random numbers until we reach the desired size
        while (uniqueNumbers.size() < size) {
            int number = random.nextInt(range + 1); // Range: [0, range]
            uniqueNumbers.add(number);
        }

        // Convert the set to an array
        int[] array = new int[size];
        int index = 0;
        for (int num : uniqueNumbers) {
            array[index++] = num;
        }

        return array;
    }
    
    public static int[] sorted(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
    
    public static int[] reverseSorted(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length); 
        Arrays.sort(sortedArray);

        // Reverse the sorted array
        int left = 0, right = sortedArray.length - 1;
        while (left < right) {
            int temp = sortedArray[left];
            sortedArray[left] = sortedArray[right];
            sortedArray[right] = temp;
            left++;
            right--;
        }
        return sortedArray; // Return the reversed array
    }
}
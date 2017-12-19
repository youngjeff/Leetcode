//package com.jeff.lang;
//
//public class GetOptSimple {
//    public static void main(String[] args){
//        GetOpt go = new GetOpt("h");
//        char c;
//        while((c = go.getopt(args)) != 0){
//            switch(c){
//                case 'h':
//                    helpAndExit(0);
//                    break;
//                default:
//                    System.err.println("Ubknown option in" + args[go.getOptind() - 1]);
//                    helpAndExit(1);
//            }
//        }
//        System.out.println();
//    }
//
//    public static void helpAndExit(int returnValue) {
//        System.err.println("Thios would tell you how yo use this program");
//        System.exit(returnValue);
//    }
//}

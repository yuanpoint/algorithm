package com.cn.Rare;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.*;
import java.util.*;

/**
 * 用Java实现赫夫曼编码
 */
public class Rare {

    public static void main(String[] args) throws ClassNotFoundException {
        //给定一个字符串
//        String msg="can you can a can as a can canner can a can.";
//        //将字符串改成比特编码，其实就是ascll编码
//        byte[] bytes = msg.getBytes();
//
//        //调用赫夫曼编码
//        byte[] b = huffmanCode(bytes);
//
//        //解码方法
//        byte[] newBytes = decode(huffCodes,b);

        String src = "/Users/mac/IdeaProjects/algorithm/src/main/java/com/cn/Rare/2.zip";
        String dst =  "/Users/mac/IdeaProjects/algorithm/src/main/java/com/cn/Rare/1.bmp";
        try{
            unZip(src,dst);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 压缩文件
     * @param src 需要压缩的文件
     * @param dst 压缩问存在的位置
     */
    public static void zipFile(String src,String dst) throws IOException {
        //创建一个输入流
        InputStream is = new FileInputStream(src);
        //创建一个和输入流指向的文件大小一样的byte数组
        byte[] b = new byte[is.available()];

        //读取文件内容
        is.read(b);
        is.close();

        //使用赫夫曼进行编码
        byte[] byteZip = huffmanCode(b);

        //进行储存
        //搞一个输出流
        OutputStream os = new FileOutputStream(dst);
        ObjectOutputStream oss = new ObjectOutputStream(os);
        //把压缩后的字节放入输出流中
        oss.writeObject(byteZip);
        //把编码表也放入进去
        oss.writeObject(huffCodes);
        //关闭资源
        oss.close();
    }

    /**
     * 解压缩文件
     * @param src
     * @param dst
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void unZip(String src,String dst) throws IOException, ClassNotFoundException {
        //创建一个输入流
        InputStream is = new FileInputStream(src);
        //读取byte数组
        ObjectInputStream ois = new ObjectInputStream(is);
        byte[] b = (byte[]) ois.readObject();

        Map<Byte,String> codes = (Map<Byte,String>) ois.readObject();
        ois.close();
        is.close();
        //解码
        byte[] bytes = decode(codes,b);

        //创建一个输出流
        OutputStream os = new FileOutputStream(dst);
        os.write(bytes);
        os.close();

    }
    /**
     * 解码文件
     * @param huffCodes
     * @param bytes
     * @return
     */
    public static byte[] decode(Map<Byte,String> huffCodes,byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<bytes.length;i++){
            byte b = bytes[i];
            boolean flag = (i==bytes.length-1);
            sb.append(byteToBitStr(!flag,b));
        }
        //把字符串按照指定的赫夫曼编码进行编码
        Map<String,Byte> map = new HashMap<String, Byte>();
        for(Map.Entry<Byte,String> entry:huffCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte> list = new ArrayList<Byte>();
        for(int i=0;i<sb.length();){
            Byte b=null;
            int count = 1;
            Boolean flag = true;
            //截取出一个Byte
            while (flag){
                String key = sb.substring(i,i+count);
                b = map.get(key);
                if(b == null){
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i+=count;
        }
        //把集合转成数组
        byte[] b = new byte[list.size()];
        for(int i=0;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将字符串转成二进制字符串
     * @param b
     * @return
     */
    private static String byteToBitStr(Boolean flag,byte b){
        int temp=b;
        if(flag){
            temp|=256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8);
        }else{
            return str;
        }
    }
    /**
     * 赫夫曼编码
     */
    public static byte[] huffmanCode(byte[] bytes){

        //获取节点
        List<Node> nodes = getNode(bytes);

        //构建赫夫曼树
        Node tree = createHuffmanTree(nodes);

        //创建赫夫曼编码表
        Map<Byte,String> huffCodes = getCodes(tree);

        //编码
        byte[] b = zip(bytes,huffCodes);
        return b;
    }

    /**
     * 用赫夫曼编码表进行编码
     * @param bytes
     * @param huffCodes
     * @return
     */
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffCodes ){

        StringBuilder sb = new StringBuilder();

        //将字节转成字符串
        for(byte b:bytes){
            sb.append(huffCodes.get(b));
        }
        int lenth;
        if(sb.length()%8 == 0){
            lenth= sb.length()/8;
        }else{
            lenth = sb.length()/8 + 1;
        }

        //每八位转成一位
        byte[] by = new byte[lenth];
        int index = 0;
        for(int i=0;i<sb.length();i+=8){
            String strByte;
            if(i+8>sb.length()){
                strByte = sb.substring(i);
            }else{
                strByte = sb.substring(i,i+8);
            }
            //将字符串转成byte数组
            by[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return by;
    }
    //创建用于记录节点的
    static StringBuilder sb = new StringBuilder();
    /**
     * 创建赫夫曼编码表
     * @param tree 赫夫曼编码树
     * @return
     */
    public static Map<Byte,String> getCodes(Node tree){
        //如果当前这个树为空，则直接返回null
        if(tree==null){
            return null;
        }
        //开始遍历左节点
        getCodes(tree.leftNode,"0",sb);
        //开始遍历右节点
        getCodes(tree.rightNode,"1",sb);
        return huffCodes;
    }
    static Map<Byte,String> huffCodes = new HashMap<Byte, String>();

    public static void getCodes(Node node,String code,StringBuilder sb){
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        //如果为空则表示不是叶子节点
        if(node.data==null){
            getCodes(node.leftNode,"0",sb2);
            getCodes(node.rightNode,"1",sb2);
        }else{
            //如果是叶子节点，则存起来
            huffCodes.put(node.data,sb2.toString());
        }
    }
    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes){

       while (nodes.size()>1){
           //进行排序
           Collections.sort(nodes);
           //取出最小的，进行设置左右节点
           Node leftNode = nodes.get(nodes.size()-1);
           Node rightNode = nodes.get(nodes.size()-2);

           //然后新创建一个节点，作为上面左右节点的根节点
           Node parent = new Node(null,leftNode.weights+rightNode.weights);
           //然后设置左右节点
           parent.leftNode = leftNode;
           parent.rightNode = rightNode;
           //然后移除这个两个节点
           nodes.remove(leftNode);
           nodes.remove(rightNode);
           //然后把这个节点添加到原节点
           nodes.add(parent);
       }

        return nodes.get(0);
    }
    /**
     * 统计每个出现的次数
     * @param bytes
     * @return
     */
    public static List<Node> getNode(byte[] bytes){

        Map<Byte,Integer> counts = new HashMap<Byte,Integer>();

        for(byte b:bytes){
           if(counts.containsKey(b)){
               int num = counts.get(b);
               counts.put(b,num+1);
           }else{
               counts.put(b,1);
           }
        }

        //将map转成node
        List<Node> nodes = new ArrayList<Node>();
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }


}

package ������;

public class HufTree{
    public byte Byte; //��8λΪ��Ԫ���ֽ�
    public int weight;//���ֽ����ļ��г��ֵĴ���
    public String code; //��Ӧ�Ĺ���������
    public HufTree lchild,rchild;

    /**���Ե�ʱ����ӵ�**/
    public String toString(){
        return "Byte:" + Byte + ",weight:" + weight + ",code:" + code + ",+ lchild:" + lchild + ",rchild:" + rchild;
    }
}

//ͳ���ַ�Ƶ�ȵ���ʱ�ڵ�
class TmpNode implements Comparable<TmpNode>{
    public byte Byte;
    public int weight;

    @Override
    public int compareTo(TmpNode arg0) {
        if(this.weight < arg0.weight)
            return 1;
        else if(this.weight > arg0.weight)
            return -1;
        return 0;
    }
}

package com.istargazer.commonutils.data;



/**
 * 栈结构
 */
public class Stack<E> {

    private static int DEFAULT_SIZE = 16; // 默认栈大小
    private int size; // 栈大小
    private int top = 0; // 栈顶位置
    private E[] data; // 数据

    public Stack(int size) {
        this.size = size;
        data = (E[]) new Object[size];
    }

    public Stack(){
        this(DEFAULT_SIZE);
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public E push(E data) {
        if(calculateTop()){
            add(data);
        } else {
            extend();
            add(data);
        }
        return data;
    }

    /**
     * 出栈
     * @return
     */
    public E pop() {
        this.shrink();
        return 0 != top ? data[--top] : null;
    }

    /**
     * 清空栈
     */
    public void clear() {
        top = 0;
    }

    /**
     * 判断是否为空栈
     * @return
     */
    public boolean isEmpty() {
        return 0 == top;
    }

    /**
     * 元素个数
     * @return
     */
    public int length() {
        return top;
    }

    /**
     * 栈顶
     * @return
     */
    public E peek() {
        return !isEmpty() ? data[top - 1] : null;
    }

    /**
     * 打印（从栈顶到栈底）
     */
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:[");
        for(int i = length() - 1; i >= 0; i--)
            sb.append(data[i] + ",");
        int last = sb.lastIndexOf(",");
        sb.delete(last,last + 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
    /**
     * 添加数据
     * @param e
     */
    private void add(E e) {
        data[++top - 1] = e;
    }

    /**
     * 扩展数组
     */
    private void extend() {
        int times = (int) (Math.log(size) / Math.log(2)) - 4;
        times = times > 0 ? times : 1;
        size += (size/times);
        E[] temp = (E[]) new Object[size];
        System.arraycopy(data,0,temp,0,data.length);
        data = temp;
    }

    /**
     * 缩小数组
     */
    private void shrink() {
        if(top < (size / 4)){
            size /= 2;
            E[] temp = (E[]) new Object[size];
            System.arraycopy(data,0,temp,0,top);
            data = temp;
        }
    }

    /**
     * 计算栈顶位置，并返回是否溢出
     * @return
     */
    private boolean calculateTop(){
        return size > top;
    }

    public static void main(String[] args) {
        Stack s = new Stack(2);
        s.push(1);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(7);
        s.push(91);
        s.push(3);
        s.push(46);
        s.push(6);
        s.display();
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.display();
    }
}

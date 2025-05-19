import java.util.*;

import javax.swing.RowFilter.ComparisonType;

public class LinkedList<E> {
    // 노드
    class Node<E> {
        private E data;
        private Node<E> next;

        // 생성자(constructor)
        Node (E data, Node<E> next) 
        {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head;
    private Node<E> crnt;

    // 생성자(constructor)
    public LinkedList() 
    {
        head = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c)
    {
        Node<E> ptr = head;

        while (ptr != null) 
        {
            if (c.compare(obj, ptr.data) == 0)
            {
                crnt = ptr;
                return ptr.data;
            }    
            ptr = ptr.next;
        }
        return null;
    }

    // 머리 노드 삽입입
    public void addFirst(E obj)
    {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    // 꼬리 노드 삽입
    public void addLast(E obj)
    {
        if (head == null)
            addFirst(obj);
        else 
        {
            Node<E> ptr = head;
            while (ptr.next != null) 
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드 삭제
    public void removeFirst() 
    {
        if (head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드 삭제
    public void removeLast()
    {
        if (head != null)
        {
            if (head.next == null)
                removeFirst();
            else 
            {
                Node<E> ptr = head;
                Node<E> pre = head;

                while (ptr.next != null) 
                {
                    pre = ptr;
                    ptr = ptr.next;    
                }
                ptr.next = null;
                crnt = pre;
            }
        }
    }

    // 노드p 삭제
    public void remove(Node p)
    {
        if (head != null)
        {
            if (p == head)
                removeFirst();
            else
            {
                Node<E> ptr = head;

                while (ptr.next != p) 
                {
                    ptr = ptr.next;
                    if (ptr == null) return;    
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 현재 선택 노드 삭제
    public void removeCurrentNode() 
    {
        remove(crnt);
    }

    // 전체 노드 삭제
    public void clear() 
    {
        while (head != null) 
           removeFirst();    
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 진행
    public boolean next() 
    {
        if (crnt == null || crnt.next == null)
            return false;
        crnt = crnt.next;
        return true;
    }

    // 선택 노드 표시
    public void printCurrentNode() 
    {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 전체 노드 표시
    public void dump()
    {
        Node<E> ptr = head;

        while (ptr != null)
        {
            System.out.println(ptr.data);    
            ptr = ptr.next;
        }
    }
}

class LinkedListTester {
    static Scanner stdIn = new Scanner(System.in);

    // 데이터(회원번호+이름)
    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no; // 회원번호
        private String name; // 이름

        // 문자열 표현을 반환
        public String toString()
        {
            return "(" + no + ") " + name;
        }

        void scanData(String guide, int sw) 
        {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO)
            {
                System.out.println("번호: ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME)
            {
                System.out.println("이름: ");
                name = stdIn.next();
            }
        }
    }
}
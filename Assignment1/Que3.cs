using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    internal class Que3<T>
    {
        public List<T> items =new List<T>();

        public void insert(T values)
        {
            items.Add(values);
            Console.WriteLine("Element Added Successfullyyy....");
;       }

        public void delete(T values) 
        {
            
            if (items.Contains(values))
            {
                items.Remove(values);
                Console.WriteLine("Element Removed Successfullyyy...");
            }
            else
            {
                Console.WriteLine("Element is not found");
            }
        }

        public void display()
        {
            Console.Write("Elements are :- ");
            foreach (var item in items)
            {
                Console.Write(item+" ");
            }
        }

        public void update(T values,int index)
        {
            items[index-1] = values;
            Console.WriteLine("Element Updated Successfullyyy....");
            
        }

        public void search(int index)
        {
            Console.WriteLine("Element is :-"+items[index-1]);
        }
    }
}

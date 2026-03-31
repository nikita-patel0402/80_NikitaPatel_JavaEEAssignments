using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    internal class Que1<T>
    {
        private T value1;
        private T value2;

        public Que1(T val1, T val2)
        {
            value1 = val1;
            value2 = val2;
        }

        public  T add()
        {
            return (dynamic)value1 + (dynamic)value2;
        }

        public T substaction()
        {
            return (dynamic)value1 - (dynamic)value2;
        }

        public T multiplication()
        {
            return (dynamic)value1 * (dynamic)value2;
        }

        public T Division()
        {
            if ((dynamic)value2 == 0)
            {
                throw new DivideByZeroException("Cannot divide by zero.");
            }
            else
            {
                return (dynamic)value1 / (dynamic)value2;
            }
        }
    }
}

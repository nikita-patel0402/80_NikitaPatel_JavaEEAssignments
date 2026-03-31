using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_1
{
    internal interface IRepostiory<T>
    {
        void add(T item);
        T get();
    }
}

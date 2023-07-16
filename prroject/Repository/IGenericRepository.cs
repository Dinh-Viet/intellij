using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1CSharp.Repository
{
    public interface IGenericRepository<V> where V : class
    {     
        void Add(V entity);
        void Update(int id,V entity);
        void Delete(int id);
        List<V> GetAll(List<string> includes = null);
        V GetById(int id);
    }
}

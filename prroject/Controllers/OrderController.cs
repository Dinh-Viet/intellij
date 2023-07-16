using Assignment1CSharp.Models;
using Assignment1CSharp.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1CSharp.Controllers
{
    public class OrderController
    {
        private readonly IUnitOfWork _unitOfWork;
        public OrderController(IUnitOfWork unitOfWork)
        {
            _unitOfWork = unitOfWork;
        }

        public void Add(Order entity)
        {
            _unitOfWork.OrderRepository.Add(entity);
            _unitOfWork.Save();
            Console.WriteLine("Add success");
        }

        public void Delete(int id)
        {
            try
            {
                _unitOfWork.OrderRepository.Delete(id);
                _unitOfWork.Save();
                Console.WriteLine("Delete success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Delete failed: " + ex.Message);
            }
        }

        public List<Order> GetAll()
        {
            return _unitOfWork.OrderRepository.GetAll(new List<string> { "Customer" });
        }

        public Order GetById(int id)
        {
            return _unitOfWork.OrderRepository.GetById(id);
        }

        public void Update(int id, Order entity)
        {
            try
            {
                _unitOfWork.OrderRepository.Update(id, entity);
                _unitOfWork.Save();
                Console.WriteLine("Update success");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Update failed: " + ex.Message);
            }
        }
    }
}

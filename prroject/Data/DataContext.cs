using Assignment1CSharp.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1CSharp.Data
{
    public class DataContext : DbContext
    {
        private string _connectionString = "Server=DESKTOP-39AGO86\\SQLEXPRESS; Database=Assignment1CSharp; User Id=sa; Password=1172004; Trusted_Connection=True; TrustServerCertificate=True;MultipleActiveResultSets=true";
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(_connectionString);
        }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<Membership> Memberships { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<Product> Products { get; set; }
    }
}

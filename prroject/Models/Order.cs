namespace Assignment1CSharp.Models
{
    public class Order
    {
        public int Id { get; set; }
        public string Total { get; set; }

        // Danh sach cac san pham nam trong don hang
        public List<Product> Products { get; set; }

        public Customer Customer { get; set; }
        public int CustomerId { get; set; }
    }
}
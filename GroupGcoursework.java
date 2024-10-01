import java.swing;
import java.swing.table.DefaultTableModel;
import java.awt;
import java.awt.event;
import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int productId, String name, String category, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + name + ", Category=" + category + ", Price=" + price + ", Quantity=" + quantity + "]";
    }
}

class User {
    private int userId;
    private String username;
    private String password;
    private String role; // Admin, Seller, Buyer

    public User(int userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return "User [ID=" + userId + ", Username=" + username + ", Role=" + role + "]";
    }
}

class Order {
    private int orderId;
    private User user;
    private Product product;
    private int quantity;
    private String status; // Pending, Shipped, Delivered

    public Order(int orderId, User user, Product product, int quantity, String status) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and setters
    public int getOrderId() { return orderId; }
    public User getUser() { return user; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order [Order ID=" + orderId + ", User=" + user.getUsername() + ", Product=" + product.getName() + ", Quantity=" + quantity + ", Status=" + status + "]";
    }
}

public class AgricultureApplicationGUI {
    private static List<Product> productCatalog = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static int productCounter = 1;
    private static int userCounter = 1;
    private static int orderCounter = 1;

    private static JFrame frame;
    private static JTable productTable;
    private static JTable orderTable;
    private static DefaultTableModel productTableModel;
    private static DefaultTableModel orderTableModel;

    public static void main(String[] args) {
        // Create sample users
        users.add(new User(userCounter++, "admin", "password", "Admin"));
        users.add(new User(userCounter++, "seller", "password", "Seller"));
        users.add(new User(userCounter++, "buyer", "password", "Buyer"));

        // Setup main frame
        frame = new JFrame("Agriculture Application");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Setup panels
        JPanel controlPanel = new JPanel(new FlowLayout());
        JPanel productPanel = new JPanel(new BorderLayout());
        JPanel orderPanel = new JPanel(new BorderLayout());

        // Setup product table
        String[] productColumns = {"ID", "Name", "Category", "Price", "Quantity"};
        productTableModel = new DefaultTableModel(productColumns, 0);
        productTable = new JTable(productTableModel);
        productPanel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        // Setup order table
        String[] orderColumns = {"Order ID", "User", "Product", "Quantity", "Status"};
        orderTableModel = new DefaultTableModel(orderColumns, 0);
        orderTable = new JTable(orderTableModel);
        orderPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);

        // Buttons for actions
        JButton addProductButton = new JButton("Add Product");
        JButton placeOrderButton = new JButton("Place Order");
        JButton viewProductsButton = new JButton("View Products");
        JButton viewOrdersButton = new JButton("View Orders");

        controlPanel.add(addProductButton);
        controlPanel.add(placeOrderButton);
        controlPanel.add(viewProductsButton);
        controlPanel.add(viewOrdersButton);

        // Add event listeners for buttons
        addProductButton.addActionListener(e -> showAddProductDialog());
        placeOrderButton.addActionListener(e -> showPlaceOrderDialog());
        viewProductsButton.addActionListener(e -> refreshProductTable());
        viewOrdersButton.addActionListener(e -> refreshOrderTable());

        // Add panels to frame
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(productPanel, BorderLayout.WEST);
        frame.add(orderPanel, BorderLayout.EAST);

        // Set frame visible
        frame.setVisible(true);
    }

    private static void showAddProductDialog() {
        JTextField nameField = new JTextField(10);
        JTextField categoryField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField quantityField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Product", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String category = categoryField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(productCounter++, name, category, price, quantity);
            productCatalog.add(product);
            refreshProductTable();
        }
    }

    private static void showPlaceOrderDialog() {
        JTextField usernameField = new JTextField(10);
        JTextField productIdField = new JTextField(10);
        JTextField quantityField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Product ID:"));
        panel.add(productIdField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Place Order", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            int productId = Integer.parseInt(productIdField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            User user = findUserByUsername(username);
            Product product = findProductById(productId);

            if (user == null || product == null || product.getQuantity() < quantity) {
                JOptionPane.showMessageDialog(frame, "Invalid order details.");
                return;
            }

            product.setQuantity(product.getQuantity() - quantity);
            Order order = new Order(orderCounter++, user, product, quantity, "Pending");
            orders.add(order);
            refreshOrderTable();
        }
    }

    private static void refreshProductTable() {
        productTableModel.setRowCount(0);
        for (Product product : productCatalog) {
            productTableModel.addRow(new Object[]{product.getProductId(), product.getName(), product.getCategory(), product.getPrice(), product.getQuantity()});
        }
    }

    private static void refreshOrderTable() {
        orderTableModel.setRowCount(0);
        for (Order order : orders) {
            orderTableModel.addRow(new Object[]{order.getOrderId(), order.getUser().getUsername(), order.getProduct().getName(), order.getQuantity(), order.getStatus()});
        }
    }

    private static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
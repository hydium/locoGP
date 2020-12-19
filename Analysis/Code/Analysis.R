dat = read.csv("Fibonacci.csv", header = TRUE)
mean_val = dat[1,]
dat = dat[-c(1),]

dat_2 = read.csv("Fibonacci_2.csv", header = TRUE)
dat_2

x = dat_2[,1]
y = dat_2[,2]


plot(x, y, type = "p", pch = 21, col = "red", xlab = "Generation", ylab = "Fitness Value")
lines(x = (0 : (ncol(dat)-1)), y = mean_val, col = "blue")
points(x = (0 : (ncol(dat)-1)), y = mean_val, pch = 4, col = "black")
